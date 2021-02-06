package documents;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import client.Abonn�;

/**
 * @author Yanis, R�my et Alexis
 * 
 *         Classe permettant de cr�er une m�diath�que. Cette m�diath�que
 *         peut-�tre assimil� � une base de donn�es, avec des tables pour les
 *         documents, les abonn�s et les documents r�serv�s.
 */
public class M�diath�que {
	@SuppressWarnings("unused")
	private int IDMediatheque;
	private Vector<Document> documents;
	private Vector<Abonn�> abonn�s;
	private static Vector<Abonn�> abonn�sBannis;
	private Map<Document, Abonn�> r�serv�s;

	/**
	 * Constructeur d'une m�diath�que, permettant de lui assigner un num�ro
	 * identifiant. Il initialise les diff�rentes listes de la m�diath�ques
	 * (documents, abonn�s et r�serv�s).
	 * 
	 * @param num l'identifiant de la m�diath�que.
	 */
	public M�diath�que(int num) {
		IDMediatheque = num;
		documents = new Vector<>();
		abonn�s = new Vector<>();
		abonn�sBannis = new Vector<>();
		r�serv�s = Collections.synchronizedMap(new HashMap<Document, Abonn�>());
	}

	/**
	 * Setter permettant d'ajouter un document � la m�diath�que.
	 * 
	 * @param doc le document � ajouter.
	 */
	public void ajouterDocument(Document doc) {
		documents.add(doc);
	}

	/**
	 * Setter permettant d'ajouter un abonn� � la m�diath�que.
	 * 
	 * @param ab le nouvel abonn� � ajouter.
	 */
	public void ajouterAbonn�(Abonn� ab) {
		abonn�s.add(ab);
	}

	/**
	 * Getter permettant de r�cup�rer le document associ� au num�ro pass� en
	 * param�tre.
	 * 
	 * @param num�ro l'identifiant du document.
	 * @return le document associ� au num�ro pass� en param�tre, null sinon.
	 */
	public Document getDocument(int num�ro) {
		for (Document D : documents) {
			if (D.numero() == num�ro) {
				return D;
			}
		}
		return null;
	}

	/**
	 * Getter permettant de r�cup�rer l'abonn� associ� au num�ro pass� en param�tre.
	 * 
	 * @param num�ro l'identifiant de l'abonn�.
	 * @return l'abonn� associ� au num�ro pass� en param�tre, null sinon.
	 */
	public Abonn� getAbonne(int num�ro) {
		for (Abonn� A : abonn�s) {
			if (A.getNum�ro() == num�ro) {
				return A;
			}
		}
		return null;
	}

	/**
	 * Getter permettant de r�cup�rer les documents r�serv�s.
	 * 
	 * @return la HashMap contenant les documents r�serv�s.
	 */
	public Map<Document, Abonn�> getR�serv�() {
		return r�serv�s;
	}

	/**
	 * Getter permettant de r�cup�rer les abonn�s bannis
	 * 
	 * @note Les abonn�s sont bannis pour toutes les m�diath�ques (m�thode static)
	 * @return la liste des abonn�s bannis
	 */
	public static Vector<Abonn�> getAbonn�sBannis() {
		return abonn�sBannis;
	}

	/**
	 * M�thode de v�rification de la r�servation. Permet de v�rifier qu'un document
	 * est associ� au bon abonn� pass� en param�tre.
	 * 
	 * @param D le document r�serv�
	 * @param A l'abonn� qui a � priori r�serv� le document
	 * @return true si l'abonn� � r�serv� le document, false sinon.
	 */
	public boolean v�rificationR�servation(Document D, Abonn� A) {
		for (Entry<Document, Abonn�> entry : r�serv�s.entrySet()) {
			if (entry.getKey() == D && entry.getValue() == A) {
				return true;
			}
		}
		return false;
	}

	/**
	 * M�thode permettant de renvoyer les documents poss�d�s par la m�diath�que sous
	 * forme de cha�ne de caract�res. Ces documents peuvent �tre disponible, r�serv�
	 * ou emprunt�.
	 * 
	 * @return la chaine de caract�res correspondante.
	 */
	public String toString() {
		String s = "";
		s += "Documents pr�sents dans la m�diath�que\n";
		for (Document D : documents) {
			s += D.toString() + "\n";
		}
		return s;
	}
}
