package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Yanis, R�my et Alexis
 * 
 *         Classe permettant le lancement de l'application cliente qui permet
 *         d'acc�der � un service (� noter que le port du service et l'ip du
 *         serveur doivent �tre rentr�s dans le tableau d'arguments du main()).
 */
public class AppliClient {
	/**
	 * @note Il faut rentrer le port associ� � la socket client en argument de la
	 *       ligne de commande Cela facilitera l'impl�mentation du logiciel sur les
	 *       bornes de la m�diath�que.
	 * @param args[0] l'ip du serveur (ici localhost)
	 * @param args[1] le port associ� au service demand�
	 */
	public static void main(String[] args) {
		try {
			Socket socket = null;
			socket = new Socket(args[0], Integer.parseInt(args[1]));
			BufferedReader sin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter sout = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.println(sin.readLine());
				if (!sin.ready())
					break;
			}

			while (true) {
				sout.flush();
				System.out.println(sin.readLine());
				String UserIn = clavier.readLine();
				sout.println(UserIn);
				if (!sin.ready())
					break;
			}
			System.out.println(sin.readLine());
			socket.close();

		} catch (IOException e) {
		}

	}

}
