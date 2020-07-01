package connexions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe éxécutable qui permet de tester une connextion simple a une base de
 * données distante
 * 
 * @author antoinelabeeuw
 *
 */
public class TestConnexionJbdc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// enregistrement du pilote
		Class.forName("org.mariadb.jdbc.Driver");
		// 2 : creation de la connextion
		// methode basique sans fichier .properties
		String url = "jdbc:mariadb://localhost:3306/compta";
		String utilisateur = "admin2";
		String pass = "";
		
		Connection connexion = DriverManager.getConnection(url, utilisateur, pass);
		System.out.println(connexion);
		
		connexion.close();
	}

}
