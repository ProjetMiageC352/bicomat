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
	 * Demande de vérifier si un Tiers existe pour un nom, prenom et numero de compte
	 * @param nom
	 * @param prenom
	 * @param numcompte
	 * @return
	 */
	public boolean existeAvecNomPrenomNumCompte(String nom, String prenom,String numcompte,int idclient ) {
		return this.tiersDAO.existeAvecNomPrenomNumCompte(nom, prenom,numcompte,idclient );
	}
	/**
	 * Demande la liste des tiers.
	 *
	 * @return la liste des tiers
	 */
	@Transactional(readOnly=true)
	public List<Tiers> listeTiers() {
		return this.tiersDAO.listeTiers();
	}
	/**
	 * Demande la liste des tiers actifs pour un client.
	 *
	 * @return la liste des tiers
	 */
	@Transactional
	public List<Tiers> listeTiersActifsPourClient(int id) {
		return this.tiersDAO.listeTiersActifsPourClient(id);
	}
	/**
	 * Demande de retourner un tiers pour un id.
	 * 
	 * @param id
	 * @return le tiers
	 */
	public Tiers getTiersAvecId(int id) {
		return this.tiersDAO.getTiersAvecId(id);
	}
	
}
