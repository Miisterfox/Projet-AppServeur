package timer;

import java.util.TimerTask;

import client.Abonn�;
import documents.Document;
import documents.M�diath�que;
import exceptions.RetourException;

/**
 * @author Yanis, R�my et Alexis
 * 
 *         Classe permettant la mise en place du compte � rebours pour la
 *         r�servation
 */
public class TimerRetour extends TimerTask {
	private Document document;
	private M�diath�que m�diath�que;
	@SuppressWarnings("unused")
	private Abonn� abonn�;

	/**
	 * Constructeur de la t�che du timer de r�servation
	 * 
	 * @param D le document r�serv�
	 * @param M la m�diath�que dans laquelle le document est r�serv�
	 * @param A l'abonn� qui a r�serv� le document
	 */
	public TimerRetour(Document D, M�diath�que M, Abonn� A) {
		document = D;
		m�diath�que = M;
	}

	/**
	 * M�thode Run permettant, si le Timer n'a pas �t� interrompu, de retourner le
	 * document dans un �tat disponible (Temps �coul�...).
	 */
	@Override
	public void run() {
		if (m�diath�que.getR�serv�().containsKey(document)) {
			try {
				document.retour();
				m�diath�que.getR�serv�().remove(document);
			} catch (RetourException e) {
				e.printStackTrace();
			}
		}
	}

}
