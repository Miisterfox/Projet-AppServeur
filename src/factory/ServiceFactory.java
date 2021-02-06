package factory;

import java.io.IOException;
import java.net.ServerSocket;

import services.ServiceEmprunt;
import services.ServiceReservation;
import services.ServiceRetour;

/**
 * @author Yanis, R�my et Alexis
 * 
 *         Classe Factory permettant de fabriquer un service associ� au port
 *         d'une ServerSocket.
 */
public class ServiceFactory {
	/**
	 * M�thode permettant de cr�er un nouveau Thread associ� � un service (suivant
	 * le port de la socket entr�e en param�tre)
	 * 
	 * @param listen_socket la socket d'�coute
	 * @throws IOException
	 */
	public static void cr�erService(ServerSocket listen_socket) throws IOException {
		switch (listen_socket.getLocalPort()) {
		case 3000:
			while (true)
				new Thread(new ServiceReservation(listen_socket.accept())).start();
		case 4000:
			while (true)
				new Thread(new ServiceEmprunt(listen_socket.accept())).start();
		case 5000:
			while (true)
				new Thread(new ServiceRetour(listen_socket.accept())).start();
		}
	}
}
