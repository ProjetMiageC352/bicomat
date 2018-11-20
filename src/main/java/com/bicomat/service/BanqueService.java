package com.bicomat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bicomat.bean.Banque;
import com.bicomat.dao.IBanqueDAO;

@Service
public class BanqueService implements IBanqueService {
	
	@Autowired
	private IBanqueDAO banqueDAO;

	public void setBanqueDAO(IBanqueDAO nBanqueDAO) {
		this.banqueDAO = nBanqueDAO;
	}

	/**
	 * Demande l'ajout d'une banque.
	 *
	 * @param b Banque à ajouter
	 */
	@Transactional
	public void ajouterBanque(Banque b) {
		this.banqueDAO.ajouterBanque(b);
	}
	/**
	 * Demande la modification d'une banque.
	 *
	 * @param b Banque à modifier
	 */
	@Transactional
	public void modifierBanque(Banque b) {
		this.banqueDAO.modifierBanque(b);
	}
	/**
	 * Demande la suppression d'une banque.
	 *
	 * @param id Id de la banque à supprimer
	 */
	@Transactional
	public void supprimerBanque(int id) {
		this.banqueDAO.supprimerBanque(id);
	}

	/**
	 * Demande la liste des banques.
	 *
	 * @return la liste des banques
	 */
	@Transactional(readOnly=true)
	public List<Banque> listeBanques() {
		return this.banqueDAO.listeBanques();
	}
	
	/**
	 * Demande la création d'une banque.
	 *
	 * @param nNom Nom de la nouvelle banque
	 * @param nAdresse Adresse de la nouvelle banque
	 */
	@Transactional
	public void creerBanque(final String nNom, final String nAdresse) {
		final Banque b = new Banque();
        b.setNom(nNom);
        b.setAdresse(nAdresse);

        this.banqueDAO.ajouterBanque(b);
	}
}
