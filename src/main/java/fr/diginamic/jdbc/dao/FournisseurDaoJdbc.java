package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDaoJdbc implements FournisseurDao {

	@Override
	public List<Fournisseur> extraire() throws SQLException, ClassNotFoundException {
		ResourceBundle database = ResourceBundle.getBundle("database");
		Class.forName(database.getString("database.driver"));
		List<Fournisseur> fournisseurs = new ArrayList<>();
		try (Connection uneConnexion = DriverManager.getConnection(database.getString("database.url"),
				database.getString("database.user"), database.getString("database.pass"))) {

			Statement statement = uneConnexion.createStatement();
			try {
				ResultSet curseur = statement.executeQuery("SELECT ID, NOM FROM FOURNISSEUR");

				while (curseur.next()) {
					Integer id = curseur.getInt("ID");
					String nom = curseur.getString("NOM");
					Fournisseur fournisseur = new Fournisseur(id, nom);
					fournisseurs.add(fournisseur);
				}
				curseur.close();
			} finally {
				statement.close();
			}
			uneConnexion.close();
		}
		return fournisseurs;
	}

	@Override
	public void insert(Fournisseur fournisseur) throws SQLException, ClassNotFoundException {
		ResourceBundle database = ResourceBundle.getBundle("database");
		Class.forName(database.getString("database.driver"));
		try (Connection uneConnexion = DriverManager.getConnection(database.getString("database.url"),
				database.getString("database.user"), database.getString("database.pass"))) {

			Statement statement = uneConnexion.createStatement();
			try {
				int nbLignes = statement.executeUpdate("INSERT INTO FOURNISSEUR (ID,NOM) VALUES (" + fournisseur.getId()
						+ ",'" + fournisseur.getNom() + "'");
				System.out.println("nombre de lignes insérées : " + nbLignes);
			} finally {
				statement.close();
			}
			uneConnexion.close();
		}

	}

	@Override
	public int update(String ancienNom, String nouveauNom) throws SQLException, ClassNotFoundException {
		ResourceBundle database = ResourceBundle.getBundle("database");
		Class.forName(database.getString("database.driver"));
		int nb = 0;
		try (Connection uneConnexion = DriverManager.getConnection(database.getString("database.url"), database.getString("database.user"), database.getString("database.pass"))) {

				String sql = "UPDATE FOURNISSEUR SET NOM=? Where NOM=?";
				PreparedStatement pstatement = uneConnexion.prepareStatement(sql);
				pstatement.setString(1, nouveauNom);
				pstatement.setString(2, ancienNom);
				try {
					nb =  pstatement.executeUpdate();
				} finally {
					pstatement.close();
				}
				uneConnexion.close();
			}
		return nb;
		}


	@Override
	public boolean delete(Fournisseur fournisseur) throws SQLException, ClassNotFoundException {
		boolean deleteCheck = false;
		ResourceBundle database = ResourceBundle.getBundle("database");
		Class.forName(database.getString("database.driver"));
		try (Connection uneConnexion = DriverManager.getConnection(database.getString("database.url"), database.getString("database.user"), database.getString("database.pass"))) {
			String sql = "DELETE FROM FOURNISSEUR WHERE ID=?";
			PreparedStatement pstatement = uneConnexion.prepareStatement(sql);
			pstatement.setInt(1, fournisseur.getId());
			try {
				int nb = pstatement.executeUpdate();
				deleteCheck = true;
			} finally {
				pstatement.close();
			}
			uneConnexion.close();
		}
		return deleteCheck;
	}

}
