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
	 * Demande la liste des tiers.
	 *
	 * @return la liste des tiers
	 */
	public List<Tiers> listeTiers();
	/**
	 * Retourne la liste des tiers actifs pour un client.
	 *
	 * @return la liste des tiers
	 */
	public List<Tiers> listeTiersActifsPourClient(int id);
	/**
	 * Retourne un tiers pour un id.
	 * 
	 * @param id
	 * @return le tiers
	 */
	public Tiers getTiersAvecId(int id);
	/**
	 * Demande de vérifier si un Tiers existe pour un nom, prenom et numero de compte
	 * @param nom
	 * @param prenom
	 * @param numcompte
	 * @return
	 */
	public boolean existeAvecNomPrenomNumCompte(String nom, String prenom,String numcompte, int idclient );
}
