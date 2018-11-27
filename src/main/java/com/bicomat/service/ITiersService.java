package com.bicomat.service;

import java.util.List;

import com.bicomat.bean.Tiers;

public interface ITiersService {

	/**
	 * Demande l'ajout une tiers.
	 *
	 * @param c Tiers à ajouter
	 */
	public void creerTiers(Tiers c);
	
	/**
	 * Demande la liste des tiers.
	 *
	 * @return la liste des tiers
	 */
	public List<Tiers> listeTiers();
	/**
	 * Demande la liste des tiers actifs pour un client.
	 *
	 * @return la liste des tiers
	 */
	public List<Tiers> listeTiersActifsPourClient(int id);
	/**
	 * Demande de retourner un tiers pour un id.
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
	public boolean existeAvecNomPrenomNumCompte(String nom, String prenom,String numcompte,int idclient );
}
