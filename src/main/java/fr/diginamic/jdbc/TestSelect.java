package fr.diginamic.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

/** Classe éxécutable 
 * @author antoinelabeeuw
 *
 */
public class TestSelect {

	public static void main(String[] args) throws ClassNotFoundException{
		List<Fournisseur> fournisseurs = new ArrayList<>();
		FournisseurDaoJdbc daoJbdc = new FournisseurDaoJdbc();
		try {
			fournisseurs = daoJbdc.extraire();
		} catch (SQLException e) {
			System.err.println("Erreur d'extraction");
			e.printStackTrace();
		}
		fournisseurs.forEach(System.out::println);
	}

}
