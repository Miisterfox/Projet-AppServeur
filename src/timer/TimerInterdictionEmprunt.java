package timer;

import java.util.TimerTask;
import client.Abonn�;
import documents.M�diath�que;

/**
 * @author Yanis, R�my et Alexis
 * 
 * Classe permettant la mise en place du compte � rebours pour le banissement
 * d'un utilisateur apr�s retard ou d�gradation
 */
public class TimerInterdictionEmprunt extends TimerTask{
	private Abonn� abonn�Interdit;
	
	/**
	 * Constructeur de la t�che du timer d'interdiction d'emprunt
	 * @param A l'abonn� qui a effectu� la faute
	 */
	public TimerInterdictionEmprunt(Abonn� A) {
		abonn�Interdit = A;
	}
	
	/**
	 * M�thode Run qui, apr�s que le temps du Timer soit �coul�, retire l'abonn�
	 * bannis de la liste des bannis des m�diath�ques.
	 */
	@Override
	public void run() {
		M�diath�que.getAbonn�sBannis().remove(abonn�Interdit);
	}
}
