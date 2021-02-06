package exceptions;

/**
 * @author Yanis, R�my et Alexis
 * 
 *         Exception li� au fait que le retour du document est impossible,
 *         puisqu'il n'est ni emprunt� ni r�serv�
 *
 */
public class RetourException extends Exception {
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "Retour impossible, le document n'est ni r�serv� ni emprunt�";
	}
}
