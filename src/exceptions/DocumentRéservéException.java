package exceptions;

/**
 * @author Yanis, R�my et Alexis
 * 
 *         Exception li� au fait que le document est r�serv� par un autre
 *         abonn�, il ne peut donc pas �tre emprunt�
 *
 */
public class DocumentR�serv�Exception extends Exception {
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "Ce document est r�serv�, il ne peut pas �tre emprunt�";
	}
}
