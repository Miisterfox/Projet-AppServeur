package etatDocument;

import client.Abonn�;
import documents.Document;
import exceptions.EmpruntException;
import exceptions.RetourException;
import exceptions.R�servationException;

/**
 * @author Yanis, R�my et Alexis
 * 
 *         Interface permettant de d�finir la structure g�n�rale d'un
 *         EtatDocument. Permet de d�l�guer l'�tat d'un document � des
 *         "objets-�tats".
 */
public interface EtatDocument {
	/**
	 * Permet la v�rification de la possibilit� d'emprunt d'un document
	 * 
	 * @param D le document � emprunter
	 * @param A l'abonn� qui emprunte le document
	 * @throws EmpruntException si l'�tat du document ne permet pas l'emprunt
	 */
	public void emprunter(Document D, Abonn� A) throws EmpruntException;

	/**
	 * Permet la v�rification de la possibilit� de r�servation d'un document
	 * 
	 * @param D le document � r�server
	 * @param A l'abonn� qui r�serve le document
	 * @throws R�servationException si l'�tat du document ne permet pas la
	 *                              r�servation
	 */
	public void r�server(Document D, Abonn� A) throws R�servationException;

	/**
	 * Permet la v�rification de la possibilit� de retour d'un document
	 * 
	 * @param D le document � retourner
	 * @throws RetourException si l'�tat du document ne permet pas le retour
	 */
	public void retourner(Document D) throws RetourException;
}
