package fr.diginamic.jdbc;

import java.sql.SQLException;

import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;

/**
 * @author antoinelabeeuw
 *
 */
public class TestUpdate {
	public static void main(String[] args) throws SQLException {
		FournisseurDaoJdbc daoJbdc = new FournisseurDaoJdbc();
		int nb = 0;
		try {
			nb = daoJbdc.update("La maison des Peintures", "La maison de la Peinture");
		} catch (SQLException e) {
			System.err.println("Erreur d'extraction");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(nb);

	}
}
