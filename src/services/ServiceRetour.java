package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import client.Abonn�;
import documents.Document;
import exceptions.RetourException;
import timer.TimerInterdictionEmprunt;

/**
 * @author Yanis, R�my et Alexis
 * 
 *         Classe permettant le lancement du service de retour de document
 */
public class ServiceRetour extends Service implements Runnable {

	/**
	 * Le constructeur d'un service de retour
	 * 
	 * @param socket la socket associ�e
	 */
	public ServiceRetour(Socket socket) {
		super(socket);
	}

	/**
	 * M�thode Run permettant d'offrir au client le service de retour. Apr�s la
	 * saisie du num�ro du DVD qu'il veut retourner, le document est retourn� s'il
	 * est actuellement emprunt� ou r�serv�. Essayer de retourner un document dans
	 * d'autres conditions l�ve des exceptions associ�es.
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(getSocket().getInputStream()));
			PrintWriter out = new PrintWriter(getSocket().getOutputStream(), true);
			out.println("Bienvenue dans le service de retour !");
			Thread.sleep(500);

			out.println("Entrez le num�ro du Document � retourner");
			out.println("Entrez votre num�ro d'abonn�");
			out.println("Le document � t-il �t� d�grad� ? rendu en retard ? O - N");
			int noDoc = Integer.parseInt(in.readLine());
			int noAbonn� = Integer.parseInt(in.readLine());
			String faute = in.readLine();
			Date today = new Date();
			today = Calendar.getInstance().getTime();
			today.setMonth(Calendar.getInstance().getTime().getMonth() + 1);
			Document doc = null;
			Abonn� ab = null;
			String S = "";
			doc = getM�diath�que().getDocument(noDoc);
			synchronized (doc) {
				if (doc != null && (ab = getM�diath�que().getAbonne(noAbonn�)) != null) {
					try {
						doc.retour();
						if (faute.toUpperCase().startsWith("O")) {
							Timer T = new Timer();
							T.schedule(new TimerInterdictionEmprunt(ab), today);
							S = ". Vous avez �t� banni 1 mois pour votre faute";
						}
						out.println(toString() + S);
					} catch (RetourException e) {
						out.println(e);
					}
				}
			}

			getSocket().close();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * M�thode permettant d'obtenir la cha�ne de caract�res assurant du bon
	 * d�roulement du service.
	 */
	@Override
	public String toString() {
		return "Le document a �t� retourn� avec succ�s";
	}
}
