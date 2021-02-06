package documents;

import client.Abonn�;
import exceptions.EmpruntException;
import exceptions.RetourException;
import exceptions.R�servationException;

/**
 * @author JFBrette
 * 
 *         Interface permettant de d�finir la structure g�n�rale d'un document
 */
public interface Document {

	/**
	 * Getter permettant de r�cuperer le num�ro du document
	 * 
	 * @return le num�ro du document
	 */
	int numero();

	/**
	 * Permet de r�server un document pour un abonn� donn�. Change l'�tat du
	 * document de disponible � r�serv�.
	 * 
	 * @param ab l'abonn� qui r�serve le document
	 * @throws R�servationException si le document ne peut �tre r�serv�
	 */
	void reservationPour(Abonn� ab) throws R�servationException;

	/**
	 * Permet d'emprunter un document pour un abonn� donn� Change l'�tat du document
	 * de disponible/r�serv� � emprunt�
	 * 
	 * @param ab l'abonn� qui emprunte le document
	 * @throws EmpruntException si le document ne peut pas �tre r�serv�
	 */
	void empruntPar(Abonn� ab) throws EmpruntException;

	/**
	 * Permet de retourner un document emprunt� ou r�serv� Change l'�tat du document
	 * de emprunt�/r�serv� � disponible
	 * 
	 * @throws RetourException si le document ne peut pas �tre retourner
	 */
	void retour() throws RetourException;
}
