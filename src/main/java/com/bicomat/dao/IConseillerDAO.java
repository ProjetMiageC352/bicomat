package com.bicomat.dao;

import java.util.List;

import com.bicomat.bean.Conseiller;

public interface IConseillerDAO {

	/**
	 * Ajoute un conseiller.
	 *
	 * @param c Conseiller à ajouter
	 */
	public void ajouterConseiller(Conseiller c);
	/**
	 * Modifie un conseiller.
	 *
	 * @param c Conseiller à modifier
	 */
	public void modifierConseiller(Conseiller c);
	/**
	 * Supprime un conseiller.
	 *
	 * @param id Id du conseiller à supprimer
	 */
	public void supprimerConseiller(int id);
	
	/**
	 * Retourne la liste des conseiller.
	 *
	 * @return la liste des conseillers de la table
	 */
	public List<Conseiller> listeConseillers();
}
