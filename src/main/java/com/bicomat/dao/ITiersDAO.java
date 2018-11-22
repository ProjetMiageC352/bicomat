package com.bicomat.dao;

import java.util.List;

import com.bicomat.bean.Tiers;

public interface ITiersDAO {

	/**
	 * Ajoute une tiers.
	 *
	 * @param b Tiers à ajouter
	 */
	public void creerTiers(Tiers t);
	/**
	 * Modifie une tiers.
	 *
	 * @param b Tiers à modifier
	 */
	
	public List<Tiers> listeTiers();
	/**
	 * Demande de vérifier si un Tiers existe pour un nom, prenom et numero de compte
	 * @param nom
	 * @param prenom
	 * @param numcompte
	 * @return
	 */
	public boolean existeAvecNomPrenomNumCompte(String nom, String prenom,String numcompte, int idclient );
}
