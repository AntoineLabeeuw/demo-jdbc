package fr.diginamic.jdbc;

import java.sql.SQLException;

import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

/**
 * Classe éxécutable pour l'insertion dans une BDD
 * 
 * @author antoinelabeeuw
 *
 */
public class TestInsertion {

	public static void main(String[] args) throws ClassNotFoundException {
		Fournisseur  fourniTest = new Fournisseur(4,"La maison des Peintures");
		FournisseurDaoJdbc daoJbdc = new FournisseurDaoJdbc();
		try {
			daoJbdc.insert(fourniTest);
		} catch (SQLException e) {
			System.err.println("Erreur d'insertion");
			e.printStackTrace();
		}
	}
}
