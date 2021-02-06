package factory;

import java.io.IOException;
import java.net.ServerSocket;

import services.Services;

/**
 * @author Yanis, R�my et Alexis
 * 
 *         Classe Factory permettant de fabriquer des ServerSocket suivant le
 *         service associ�.
 */
public class ServerSocketFactory {
	/**
	 * M�thode permettant de cr�er une ServerSocket suivant un Service
	 * 
	 * @param Service le Service de la ServerSocket
	 * @return un objet ServerSocket ouvert au port associ� au Service, null si le
	 *         service n'existe pas
	 * @throws IOException
	 */
	public static ServerSocket cr�erServerSocket(Services Service) throws IOException {
		switch (Service) {
		case RESERVATION:
			return new ServerSocket(3000);
		case EMPRUNT:
			return new ServerSocket(4000);
		case RETOUR:
			return new ServerSocket(5000);
		}
		return null;
	}
}
