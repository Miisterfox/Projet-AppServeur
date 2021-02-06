package client;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author Yanis, R�my et Alexis
 * 
 *         Classe permettant de cr�er un abonn�, client de la m�diath�que.
 */
public class Abonn� {
	private final int num�ro;
	@SuppressWarnings("unused")
	private String nom;
	private LocalDate naissance;

	/**
	 * Constructeur d'un abonn� permettant de lui assigner un identifiant, un nom et
	 * une date de naissance
	 * 
	 * @param num       l'identifiant de l'abonn�
	 * @param nom       le nom de l'abonn�
	 * @param naissance la date de naissance de l'abonn�
	 */
	public Abonn�(int num, String nom, LocalDate naissance) {
		this.num�ro = num;
		this.nom = nom;
		this.naissance = naissance;
	}

	/**
	 * Getter permettant d'obtenir le num�ro de l'abonn�
	 * 
	 * @return le num�ro identifiant l'abonn�
	 */
	public int getNum�ro() {
		return num�ro;
	}

	/**
	 * Getter permettant d'obtenir l'�ge de l'abonn�
	 * 
	 * @return l'�ge de l'abonn�
	 */
	public int getAge() {
		return Period.between(naissance, LocalDate.now()).getYears();
	}
}
