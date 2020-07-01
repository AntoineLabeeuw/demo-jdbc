package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

/** Classe éxécutable 
 * @author antoinelabeeuw
 *
 */
public class TestSelect {

	public static void main(String[] args) throws SQLException {
		ResourceBundle database = ResourceBundle.getBundle("database");
		String url = database.getString("database.url");
		String utilisateur = database.getString("database.user");
		String motDePasse = database.getString("database.pass");
		try (Connection uneConnexion = DriverManager.getConnection(url, utilisateur, motDePasse)) {

			Statement statement = uneConnexion.createStatement();
			try {
				ResultSet curseur = statement.executeQuery("SELECT ID, NOM FROM FOURNISSEUR");
				List<Fournisseur> fournisseurs = new ArrayList<>();
				
				while (curseur.next()) {
					Integer id = curseur.getInt("ID");
					String nom = curseur.getString("NOM");
					Fournisseur fournisseur = new Fournisseur(id, nom); 
					fournisseurs.add(fournisseur);
					}
				curseur.close();
				
				for(Fournisseur f : fournisseurs) {
					System.out.println(f.getId() + " | " + f.getNom());
				}
			} finally {
				statement.close();
			}
			uneConnexion.close();
		}
	}

}
