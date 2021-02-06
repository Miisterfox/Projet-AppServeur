package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import documents.Document;
import documents.M�diath�que;
import exceptions.DocumentR�serv�Exception;
import exceptions.EmpruntException;
import client.Abonn�;

/**
 * @author Yanis, R�my et Alexis
 * 
 *         Classe permettant le lancement du service d'emprunt de document.
 */
public class ServiceEmprunt extends Service implements Runnable {

	/**
	 * Le constructeur d'un service de r�servation
	 * 
	 * @param socket la socket associ�e
	 */
	public ServiceEmprunt(Socket socket) {
		super(socket);
	}

	/**
	 * M�thode Run permettant d'offrir au client le service d'emprunt. Apr�s la
	 * saisie du num�ro du DVD qu'il veut r�server et de son num�ro client il
	 * emprunte le document de la m�diath�que s'il est disponible ou qu'il l'a
	 * r�serv�. Essayer de retourner un document dans d'autres conditions l�ve des
	 * exceptions associ�es.
	 */
	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(getSocket().getInputStream()));
			PrintWriter out = new PrintWriter(getSocket().getOutputStream(), true);
			out.println(getM�diath�que().toString());
			Thread.sleep(500);
			out.flush();
			out.println("Entrez le num�ro du DVD � louer");
			out.println("Entrez votre num�ro d'abonn�");
			int noDoc = Integer.parseInt(in.readLine());
			int noAbonn� = Integer.parseInt(in.readLine());
			Document doc = null;
			Abonn� ab = null;
			doc = getM�diath�que().getDocument(noDoc);
			ab = getM�diath�que().getAbonne(noAbonn�);
			synchronized (doc) {
				if (doc != null && !M�diath�que.getAbonn�sBannis().contains(ab)) {
					try {
						if (getM�diath�que().getR�serv�().containsKey(doc)
								&& !getM�diath�que().v�rificationR�servation(doc, ab)) {
							throw new DocumentR�serv�Exception();
						} else {
							doc.empruntPar(ab);
							if (getM�diath�que().getR�serv�().containsKey(doc))
								getM�diath�que().getR�serv�().remove(doc);
							out.println(toString());
						}
					} catch (EmpruntException | DocumentR�serv�Exception e) {
						out.println(e);
					}
				}
			}
			System.out.println("Connexion termin�e");

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
		return "Le document a �t� emprunt� avec succ�s";
	}
}
