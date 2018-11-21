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
	 * Vérifie si un conseiller existe pour un login et un mot de passe.
	 *
	 * @param login Login à vérifier
	 * @param password Password à vérifier
	 * @return existe Vrai si un conseiller existe avec le login et le mot de passe
	 */
	public boolean existeAvecLoginPassword(String login, String password);
	
	/**
	 * Retourne la liste des conseiller.
	 *
	 * @return la liste des conseillers de la table
	 */
	public List<Conseiller> listeConseillers();
}
