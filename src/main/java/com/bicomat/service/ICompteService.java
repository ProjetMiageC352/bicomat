package com.bicomat.service;

import java.util.List;

import com.bicomat.bean.Compte;

public interface ICompteService {

	/**
	 * Demande l'ajout d'un compte.
	 *
	 * @param c Compte à ajouter
	 */
	public void ajouterCompte(Compte c);
	/**
	 * Demande la modification d'un compte.
	 *
	 * @param c Compte à modifier
	 */
	public void modifierCompte(Compte c);
	/**
	 * Demande la suppression d'un compte.
	 *
	 * @param id Id du compte à supprimer
	 */
	public void supprimerCompte(int id);
	
	/**
	 * Demande la liste des comptes.
	 *
	 * @return la liste des comptes
	 */
	public List<Compte> listeComptes();
	/**
	 * Demande la liste des comptespar client.
	 *
	 * @return la liste des comptes
	 */
	public List<Compte> listeComptesparclient(int id);
	/**
	 * Demande la création d'un compte.
	 *
	 * @param nType Type du nouveau compte
	 * @param nDecouvert Decouvert autorisé du nouveau compte
	 * @param nSolde Solde du nouveau compte
	 * @param nIdBanque Id de la banque du nouveau compte
	 * @param nIdCompte Id du client du nouveau compte
	 */
	public void creerCompte(final String nType, final boolean nDecouvert,
			final double nSolde, final int nIdBanque, final int nIdClient);
}
