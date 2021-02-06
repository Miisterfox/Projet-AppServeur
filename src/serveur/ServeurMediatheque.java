package serveur;

import java.io.IOException;
import java.net.ServerSocket;

import factory.ServerSocketFactory;
import factory.ServiceFactory;
import services.Services;

/**
 * @author Yanis, R�my et Alexis
 * 
 *         Serveur de la m�diath�que, �coutant � un port particulier (associ� �
 *         un service).
 */
public class ServeurMediatheque implements Runnable {
	private ServerSocket listen_socket;

	/**
	 * Constructeur d'un ServeurMediatheque
	 * 
	 * @param Service le service associ� � la ServerSocket
	 * @throws IOException
	 */
	public ServeurMediatheque(Services Service) throws IOException {
		listen_socket = ServerSocketFactory.cr�erServerSocket(Service);
	}

	/**
	 * M�thode Run permettant de lancer la ServerSocket au port associ�, et
	 * d'attendre l'arriv� d'un client pour offrir le service associ�. Ces
	 * ServerSocket sont sur �coute tant que l'application est en route (� priori
	 * 24h/24h).
	 */
	@Override
	public void run() {
		try {
			System.err.println("Lancement du serveur au port " + this.listen_socket.getLocalPort());
			System.out.println(this.listen_socket.toString());
			ServiceFactory.cr�erService(listen_socket);

		} catch (IOException e) {
			try {
				this.listen_socket.close();
				System.err.println("Arr�t du serveur au port " + this.listen_socket.getLocalPort());
			} catch (IOException e1) {
			}
		}
	}

	protected void finalize() throws Throwable {
		try {
			this.listen_socket.close();
		} catch (IOException e1) {
		}
	}
}
