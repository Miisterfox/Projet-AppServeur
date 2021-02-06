package exceptions;

/**
 * @author Yanis, R�my et Alexis
 * 
 *         Exception li� au fait que le document ne peut pas �tre r�serv�, soit
 *         par ce qu'il est emprunt� soit par ce qu'il est r�serv� par un autre
 *         utilisateur
 *
 */
public class R�servationException extends Exception {
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "Ce document ne peut pas �tre r�serv� pour le moment";
	}
}
