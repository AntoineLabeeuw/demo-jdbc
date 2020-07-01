package connexions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Classe éxécutable qui permet de tester une connexion simple a une base de
 * données distante (clevercloud)
 * 
 * @author antoinelabeeuw
 *
 */
public class TestConnexionTp2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Lecture du fichier de propriétés
        ResourceBundle database = ResourceBundle.getBundle("database");


        // Etape 1 - Enregistrer le pilote
        // => indiquer à JDBC une possibilité de communiquer avec une base
        // DriverManager.registerDriver(new Driver());
        Class.forName(database.getString("database.driver"));

        // Etape 2 - Créer une connexion
        String url = database.getString("database.url"); // url JDBC d'accès à la base (machine, port, le nom de la base, le type de base...)
        String utilisateur = database.getString("database.user");
        String motDePasse =  database.getString("database.pass");
        
        
        Connection uneConnexion = DriverManager.getConnection(url, utilisateur, motDePasse);
        System.out.println(uneConnexion);

        


    }

}
