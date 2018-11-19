package com.bicomat.service;

import java.util.List;

import com.bicomat.bean.Banque;

public interface IBanqueService {

	/**
	 * Demande l'ajout une banque.
	 *
	 * @param b Banque à ajouter
	 */
	public void ajouterBanque(Banque b);
	/**
	 * Demande la modification d'une banque.
	 *
	 * @param b Banque à modifier
	 */
	public void modifierBanque(Banque b);
	/**
	 * Demande la suppression d'une banque.
	 *
	 * @param id Id de la banque à supprimer
	 */
	public void supprimerBanque(int id);
	
	/**
	 * Demande la liste des banques.
	 *
	 * @return la liste des banques
	 */
	public List<Banque> listeBanques();
}
