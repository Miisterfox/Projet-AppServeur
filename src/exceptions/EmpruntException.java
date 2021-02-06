package exceptions;

/**
 * @author Yanis, R�my et Alexis
 * 
 *         Exception li� au fait que le document est d�j� emprunt�
 *
 */
public class EmpruntException extends Exception {
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "Ce document est d�j� emprunt�";
	}
}
