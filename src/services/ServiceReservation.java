package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Timer;

import client.Abonn�;
import documents.Document;
import documents.M�diath�que;
import exceptions.R�servationException;
import timer.TimerRetour;

/**
 * @author Yanis, R�my et Alexis
 * 
 *         Classe permettant le lancement du service de r�servation de document.
 */
public class ServiceReservation extends Service implements Runnable {

	/**
	 * Le constructeur d'un service de r�servation
	 * 
	 * @param socket la socket associ�e
	 */
	public ServiceReservation(Socket socket) {
		super(socket);
	}

	/**
	 * M�thode Run permettant d'offrir au client le service de r�servation. Apr�s la
	 * saisie du num�ro du DVD qu'il veut r�server et de son num�ro client il
	 * r�serve un document de la m�diath�que pendant 2 heures s'il est disponible.
	 * S'il ne vient pas le chercher dans les 2 heures suivant la r�servation,
	 * celle-ci est annul�e et le document retrouve son �tat Disponible. Essayer de
	 * r�server un document dans d'autres conditions l�ve des exceptions associ�es.
	 */
	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(getSocket().getInputStream()));
			PrintWriter out = new PrintWriter(getSocket().getOutputStream(), true);
			out.println(getM�diath�que().toString());
			Thread.sleep(500);
			out.flush();
			out.println("Entrez le num�ro du DVD � r�server");
			out.println("Entrez votre num�ro client");
			int noDoc = Integer.parseInt(in.readLine());
			int noAbonn� = Integer.parseInt(in.readLine());

			Document doc = null;
			Abonn� ab = null;
			doc = getM�diath�que().getDocument(noDoc);
			ab = getM�diath�que().getAbonne(noAbonn�);
			synchronized (doc) {
				getM�diath�que();
				if (doc != null && !M�diath�que.getAbonn�sBannis().contains(ab)) {
					try {
						doc.reservationPour(ab);
						getM�diath�que().getR�serv�().put(doc, ab);
						out.println(toString());
						Timer r�servation = new Timer();
						r�servation.schedule(new TimerRetour(doc, getM�diath�que(), ab), 7200000);
					} catch (R�servationException e) {
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
		return "Le document � �t� r�serv� avec succ�s";
	}
}
