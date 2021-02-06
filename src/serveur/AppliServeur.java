package serveur;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;

import client.Abonn�;
import documents.DVD;
import documents.M�diath�que;
import services.Service;
import services.Services;

/**
 * @author Yanis, R�my et Alexis
 * 
 *         Classe permettant le lancement de l'application serveur, qui
 *         initialise les diff�rents documents et abonn�s de la m�diath�que et
 *         qui par la suite lance les diff�rents Threads d'�coute sur les ports
 *         li�s aux services
 *
 */
public class AppliServeur {
	public static void main(String[] args) throws ParseException {
		M�diath�que m�diath�que = new M�diath�que(1);
		m�diath�que.ajouterAbonn�((new Abonn�(1, "Bouboucars", LocalDate.of(2012, Month.JANUARY, 21))));
		m�diath�que.ajouterAbonn�((new Abonn�(2, "Brette", LocalDate.of(2000, Month.JUNE, 14))));

		m�diath�que.ajouterDocument((new DVD(1, "Les sockets de No�l", false)));
		m�diath�que.ajouterDocument((new DVD(2, "Hide and Seek", true)));
		m�diath�que.ajouterDocument((new DVD(3, "Martine fait du ski", false)));
		m�diath�que.ajouterDocument((new DVD(4, "Petits Pieds du bonheur", false)));
		m�diath�que.ajouterDocument((new DVD(5, "Bagnoles 2", false)));
		m�diath�que.ajouterDocument((new DVD(6, "Le jeu de la faim", true)));
		m�diath�que.ajouterDocument((new DVD(7, "T'choupi et la magie de no�l", false)));
		m�diath�que.ajouterDocument((new DVD(8, "Rapides et dangereux", true)));
		m�diath�que.ajouterDocument((new DVD(9, "Poulets en fuite", false)));
		m�diath�que.ajouterDocument((new DVD(10, "Histoire de jouets", false)));

		Service.setM�diath�que(m�diath�que);

		try {
			new Thread(new ServeurMediatheque(Services.RESERVATION)).start();
			new Thread(new ServeurMediatheque(Services.EMPRUNT)).start();
			new Thread(new ServeurMediatheque(Services.RETOUR)).start();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

}
