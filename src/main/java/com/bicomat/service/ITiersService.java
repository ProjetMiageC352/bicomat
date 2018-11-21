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
	
	
}
