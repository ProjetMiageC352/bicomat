package com.bicomat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bicomat.bean.CarteBancaire;
import com.bicomat.dao.ICarteBancaireDAO;

@Service
public class CarteBancaireService implements ICarteBancaireService {
	
	@Autowired
	private ICarteBancaireDAO carteBancaireDAO;

	public void setCarteBancaireDAO(ICarteBancaireDAO nCarteBancaireDAO) {
		this.carteBancaireDAO = nCarteBancaireDAO;
	}

	
	/**
	 * Demande la liste des carteBancaires.
	 *
	 * @return la liste des carteBancaires
	 */
	@Transactional(readOnly=true)
	public List<CarteBancaire> listeCarteBancaires() {
		return this.carteBancaireDAO.listeCarteBancaires();
	}

}
