package com.bicomat.dao;

import java.util.List;

import com.bicomat.bean.CarteBancaire;

public interface ICarteBancaireDAO {

	
	/**
	 * Retourne la liste des carteBancaires.
	 *
	 * @return la liste des carteBancaires de la table
	 */
	public List<CarteBancaire> listeCarteBancaires();
}
