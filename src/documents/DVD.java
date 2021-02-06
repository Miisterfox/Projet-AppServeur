package documents;

import client.Abonn�;
import etatDocument.Disponible;
import etatDocument.Emprunt�;
import etatDocument.EtatDocument;
import etatDocument.R�serv�;
import exceptions.AgeException;
import exceptions.EmpruntException;
import exceptions.RetourException;
import exceptions.R�servationException;

/**
 * @author Yanis, R�my et Alexis
 * 
 *         Classe permettant de cr�er un DVD. On peut par la suite effectuer des
 *         op�rations dessus (emprunt, r�servation et retour).
 */
public class DVD implements Document {
	private final int num�ro;
	private String titre;
	private boolean adulte;
	private EtatDocument �tat;

	/**
	 * Constructeur d'un DVD permettant de lui assigner un num�ro, un titre et de
	 * savoir s'il est pour adulte ou non (bool�en).
	 * 
	 * @param num    le num�ro du DVD
	 * @param titre  le titre du DVD
	 * @param adulte l'�ge recommand� pour le film (true si pour adulte, false
	 *               sinon).
	 */
	public DVD(int num, String titre, boolean adulte) {
		this.num�ro = num;
		this.titre = titre;
		this.adulte = adulte;
		this.�tat = new Disponible();
	}

	/**
	 * @see Document#numero()
	 */
	@Override
	public int numero() {
		return num�ro;
	}

	/**
	 * @see Document#reservationPour(Abonn�)
	 */
	@Override
	public void reservationPour(Abonn� ab) throws R�servationException {
		this.�tat.r�server(this, ab);
		this.�tat = new R�serv�();
	}

	/**
	 * @note Si l'abonn� � moins de 18 ans et qu'il essaye d'emprunter un DVD pour
	 *       adulte, la m�thode l�ve l'exception li�
	 * @see AgeException
	 * @see Document#empruntPar(Abonn�)
	 */
	@Override
	public void empruntPar(Abonn� ab) throws EmpruntException {
		if (adulte && ab.getAge() < 18) {
			throw new AgeException();
		}
		this.�tat.emprunter(this, ab);
		this.�tat = new Emprunt�();
	}

	/**
	 * @see Document#retour()
	 */
	@Override
	public void retour() throws RetourException {
		this.�tat.retourner(this);
		this.�tat = new Disponible();
	}

	/**
	 * M�thode permettant de repr�senter un document sous forme de cha�ne de
	 * caract�res (titre, �tat et num�ro).
	 * 
	 * @return la chaine de caract�res correspondante.
	 */
	public String toString() {
		return titre + " : " + �tat.toString() + "\n identifiant : " + num�ro + "\n";
	}

}
