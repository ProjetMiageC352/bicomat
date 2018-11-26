package com.bicomat.dao;

import java.util.List;

import com.bicomat.bean.Compte;

public interface ICompteDAO {

	/**
	 * Ajoute un compte.
	 *
	 * @param c Compte à ajouter
	 */
	public void ajouterCompte(Compte c);
	/**
	 * Modifie un compte.
	 *
	 * @param c Compte à modifier
	 */
	public void modifierCompte(Compte c);
	/**
	 * Supprime un compte.
	 *
	 * @param id Id du compte à supprimer
	 */
	public void supprimerCompte(int id);
	
	/**
	 * Retourne la liste des comptes.
	 *
	 * @return la liste des comptes de la table
	 */
	public List<Compte> listeComptes();
	/**
	 * Demande la liste des comptespar client.
	 *
	 * @return la liste des comptes
	 */
	public List<Compte> listeComptesparclient(int id);
}
