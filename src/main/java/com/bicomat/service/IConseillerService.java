package com.bicomat.service;

import java.util.List;

import com.bicomat.bean.Conseiller;

public interface IConseillerService {

	/**
	 * Demande l'ajout d'un conseiller.
	 *
	 * @param c Conseiller à ajouter
	 */
	public void ajouterConseiller(Conseiller c);
	/**
	 * Demande la modification d'un conseiller.
	 *
	 * @param c Conseiller à modifier
	 */
	public void modifierConseiller(Conseiller c);
	/**
	 * Demande la suppression d'un conseiller.
	 *
	 * @param id Id du conseiller à supprimer
	 */
	public void supprimerConseiller(int id);
	
	/**
	 * Demande la liste des conseiller.
	 *
	 * @return la liste des conseiller
	 */
	public List<Conseiller> listeConseillers();
	
	/**
	 * Demande la création d'un conseiller.
	 */
	public void creerConseiller(final String nNom, final String nPrenom,
			final String nLoginAgency, final String nPasswordAgency,
    		final int nIdBanque);
}
