package etatDocument;

import client.Abonn�;
import documents.Document;
import exceptions.EmpruntException;
import exceptions.RetourException;
import exceptions.R�servationException;

/**
 * @author Yanis, R�my et Alexis
 * 
 *         Classe permettant de caract�riser l'�tat disponible d'un document.
 *         Dans ce cas de figure, on peut emprunter ou r�server le document
 *         associ�. Le retour l�ve les exceptions associ�es
 */
public class Disponible implements EtatDocument {

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
		return;
	}

	/**
	 * @see EtatDocument#retourner(Document, Abonn�)
	 */
	@Override
	public void retourner(Document D) throws RetourException {
		throw new RetourException();
	}

	public String toString() {
		return "Disponible";
	}
}
