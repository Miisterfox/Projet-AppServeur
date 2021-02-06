package exceptions;

/**
 * @author Yanis, R�my et Alexis
 * 
 *         Exception li� au fait que l'utilisateur qui essaie d'emprunter le
 *         document est trop jeune
 *
 */
public class AgeException extends EmpruntException {
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "Vous n'avez pas l'�ge pour emprunter ce DVD";
	}
}
