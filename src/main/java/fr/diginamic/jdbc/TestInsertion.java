package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Classe éxécutable pour l'insertion dans une BDD
 * 
 * @author antoinelabeeuw
 *
 */
public class TestInsertion {

	public static void main(String[] args) throws SQLException {
		ResourceBundle database = ResourceBundle.getBundle("database");
		String url = database.getString("database.url");
		String utilisateur = database.getString("database.user");
		String motDePasse = database.getString("database.pass");
		try (Connection uneConnexion = DriverManager.getConnection(url, utilisateur, motDePasse)) {

			Statement statement = uneConnexion.createStatement();
			try {
				int nbLignes = statement.executeUpdate("INSERT INTO FOURNISSEUR (ID,NOM) VALUES (4,'La maison de la peinture')");
				System.out.println("nombre de lignes insérées : " + nbLignes);
			} finally {
				statement.close();
			}
			uneConnexion.close();
		}
	}
}
