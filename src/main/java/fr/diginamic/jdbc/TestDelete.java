package fr.diginamic.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class TestDelete {

	public static void main(String[] args) throws SQLException {
		ResourceBundle database = ResourceBundle.getBundle("database");
		String url = database.getString("database.url");
		String utilisateur = database.getString("database.user");
		String motDePasse = database.getString("database.pass");
		try (Connection uneConnexion = DriverManager.getConnection(url, utilisateur, motDePasse)) {

			Statement statement = uneConnexion.createStatement();
			try {
				int nbLignes = statement
						.executeUpdate("DELETE FROM FOURNISSEUR WHERE ID=4");
				System.out.println("nombre de lignes supprimées : " + nbLignes);
			}
			finally {
				statement.close();
			}
			uneConnexion.close();
		}
	}

}
