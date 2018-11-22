package com.bicomat.service;

import java.util.List;

import com.bicomat.bean.CarteBancaire;

public interface ICarteBancaireService {

	/**
	 * Demande la liste des carteBancaires.
	 *
	 * @return la liste des carteBancaires
	 */
	public List<CarteBancaire> listeCarteBancaires();

}
