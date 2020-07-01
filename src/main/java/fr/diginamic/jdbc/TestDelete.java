package fr.diginamic.jdbc;



import java.sql.SQLException;


import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;


public class TestDelete {

	public static void main(String[] args) throws SQLException {
		FournisseurDaoJdbc daoJbdc = new FournisseurDaoJdbc();
		Fournisseur f = new Fournisseur(4, "La maison des Peintures");
		boolean deleteCheck = false;
		try {
			deleteCheck = daoJbdc.delete(f);
		} catch (SQLException e) {
			System.err.println("Erreur d'extraction");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(deleteCheck);

	}

}
