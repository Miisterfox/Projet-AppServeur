package etatDocument;

import client.Abonn�;
import documents.Document;
import exceptions.EmpruntException;
import exceptions.RetourException;
import exceptions.R�servationException;

/**
 * @author Yanis, R�my et Alexis
 * 
 *         Classe permettant de caract�riser l'�tat emprunt� d'un document. Dans
 *         ce cas de figure, on ne peut que retourner le document associ�.
 *         L'emprunt ou la r�servation l�ve les exceptions associ�es
 */
public class Emprunt� implements EtatDocument {

	/**
	 * @see EtatDocument#emprunter(Document, Abonn�)
	 */
	@Override
	public void emprunter(Document D, Abonn� A) throws EmpruntException {
		throw new EmpruntException();
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
		return "Emprunt�";
	}
}
