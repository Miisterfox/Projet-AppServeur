package services;

import java.net.Socket;

import documents.M�diath�que;

/**
 * @author Yanis, R�my et Alexis
 * 
 *         Classe abstraite permettant de d�finir les attributs et la structure
 *         g�n�rale d'un service. Permet d'avoir une m�diath�que g�n�ralis�
 *         entre service associ�.
 */
public abstract class Service {
	private Socket client;
	private static M�diath�que m�diath�que;

	/**
	 * Constructeur par d�faut d'un Service
	 * 
	 * @param socket la socket du service
	 */
	public Service(Socket socket) {
		client = socket;
	}

	/**
	 * Getter permettant d'obtenir la socket associ�e
	 * 
	 * @return la socket associ�e
	 */
	public Socket getSocket() {
		return client;
	}

	/**
	 * Getter permettant d'obtenir la m�diath�que associ�e au service
	 * 
	 * @return la m�diath�que associ�e
	 */
	public M�diath�que getM�diath�que() {
		return m�diath�que;
	}

	/**
	 * Setter permettant de d�finir la m�diath�que associ� aux services. (m�thode
	 * statique).
	 * 
	 * @param m la m�diath�que associ�e
	 */
	public static void setM�diath�que(M�diath�que m) {
		m�diath�que = m;
	}
}
