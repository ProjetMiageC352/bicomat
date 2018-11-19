package com.bicomat.dao;

import java.util.List;

import com.bicomat.bean.Banque;

public interface IBanqueDAO {

	/**
	 * Ajoute une banque.
	 *
	 * @param b Banque à ajouter
	 */
	public void ajouterBanque(Banque b);
	/**
	 * Modifie une banque.
	 *
	 * @param b Banque à modifier
	 */
	public void modifierBanque(Banque b);
	/**
	 * Supprime une banque.
	 *
	 * @param id Id de la banque à supprimer
	 */
	public void supprimerBanque(int id);
	
	/**
	 * Retourne la liste des banques.
	 *
	 * @return la liste des banques de la table
	 */
	public List<Banque> listeBanques();
}
