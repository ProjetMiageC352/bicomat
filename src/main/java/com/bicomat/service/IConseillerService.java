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
	 * Demande de vérifier si un conseiller existe pour un login et un mot de passe.
	 *
	 * @param login Login à vérifier
	 * @param password Password à vérifier
	 * @return existe Vrai si un conseiller existe avec le login et le mot de passe
	 */
	public boolean existeAvecLoginPassword(String login, String password);
	
	/**
	 * Demande la liste des conseillers.
	 *
	 * @return la liste des conseillers
	 */
	public List<Conseiller> listeConseillers();
	
	/**
	 * Demande la création d'un conseiller.
	 *
	 * @param nNom Nom du nouveau conseiller
	 * @param nPrenom Prenom du nouveau conseiller
	 * @param nLoginAgency Login agency du nouveau conseiller
	 * @param nPasswordAgency Mot de passe agency du nouveau conseiller
	 * @param nIdBanque Id de la banque du nouveau conseiller
	 */
	public void creerConseiller(final String nNom, final String nPrenom,
			final String nLoginAgency, final String nPasswordAgency,
    		final int nIdBanque);
}
