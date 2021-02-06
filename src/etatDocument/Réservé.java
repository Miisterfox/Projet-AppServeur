package etatDocument;

import client.Abonn�;
import documents.Document;
import exceptions.EmpruntException;
import exceptions.RetourException;
import exceptions.R�servationException;

/**
 * @author Yanis, R�my et Alexis
 * 
 *         Classe permettant de caract�ris� l'�tat r�serv� d'un document. Dans
 *         ce cas de figure, on peut emprunter ou retourner le document associ�.
 *         La r�servation l�ve les exceptions associ�es
 */
public class R�serv� implements EtatDocument {

	/**
	 * @see EtatDocument#emprunter(Document, Abonn�)
	 */
	@Override
	public void emprunter(Document D, Abonn� A) throws EmpruntException {
		return;
	}

	/**
	 * @see EtatDocument#r�server(Document, Abonn�)
	 */
	@Override
	public void r�server(Document D, Abonn� A) throws R�servationException {
		throw new R�servationException();
	}

	/**
	 * @see EtatDocument#retourner(Document, Abonn�)
	 */
	@Override
	public void retourner(Document D) throws RetourException {
		return;
	}

	public String toString() {
		return "R�serv�";
	}
}
