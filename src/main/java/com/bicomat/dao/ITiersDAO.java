package com.bicomat.dao;

import java.util.List;

import com.bicomat.bean.Tiers;

public interface ITiersDAO {

	/**
	 * Ajoute une tiers.
	 *
	 * @param b Tiers à ajouter
	 */
	public void creerTiers(Tiers t);
	/**
	 * Modifie une tiers.
	 *
	 * @param b Tiers à modifier
	 */
	
	public List<Tiers> listeTiers();
}
