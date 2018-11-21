package com.bicomat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bicomat.bean.Tiers;
import com.bicomat.dao.ITiersDAO;

@Service
public class TiersService implements ITiersService {
	
	@Autowired
	private ITiersDAO tiersDAO;

	public void setTiersDAO(ITiersDAO nTiersDAO) {
		this.tiersDAO = nTiersDAO;
	}

	/**
	 * Demande l'ajout une tiers.
	 *
	 * @param c Tiers à ajouter
	 */
	@Transactional
	public void creerTiers(Tiers t) {
		this.tiersDAO.creerTiers(t);
	}


	/**
	 * Demande la liste des tierss.
	 *
	 * @return la liste des tierss
	 */
	@Transactional(readOnly=true)
	public List<Tiers> listeTiers() {
		return this.tiersDAO.listeTiers();
	}
	
	
}
