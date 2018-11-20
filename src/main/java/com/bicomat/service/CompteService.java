package com.bicomat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bicomat.bean.Compte;
import com.bicomat.dao.ICompteDAO;

@Service
public class CompteService implements ICompteService {
	
	@Autowired
	private ICompteDAO compteDAO;

	public void setCompteDAO(ICompteDAO nCompteDAO) {
		this.compteDAO = nCompteDAO;
	}

	/**
	 * Demande l'ajout d'un compte.
	 *
	 * @param c Compte à ajouter
	 */
	@Transactional
	public void ajouterCompte(Compte c) {
		this.compteDAO.ajouterCompte(c);
	}
	/**
	 * Demande la modification d'un compte.
	 *
	 * @param c Compte à modifier
	 */
	@Transactional
	public void modifierCompte(Compte c) {
		this.compteDAO.modifierCompte(c);
	}
	/**
	 * Demande la suppression d'un compte.
	 *
	 * @param id Id du compte à supprimer
	 */
	@Transactional
	public void supprimerCompte(int id) {
		this.compteDAO.supprimerCompte(id);
	}

	/**
	 * Demande la liste des comptes.
	 *
	 * @return la liste des comptes
	 */
	@Transactional(readOnly=true)
	public List<Compte> listeComptes() {
		return this.compteDAO.listeComptes();
	}
	
	/**
	 * Demande la création d'un compte.
	 *
	 * @param nType Type du nouveau compte
	 * @param nDecouvert Decouvert autorisé du nouveau compte
	 * @param nSolde Solde du nouveau compte
	 * @param nIdBanque Id de la banque du nouveau compte
	 * @param nIdCompte Id du client du nouveau compte
	 */
	@Transactional
	public void creerCompte(final String nType, final boolean nDecouvert,
			final double nSolde, final int nIdBanque, final int nIdClient) {
		final Compte c = new Compte();
        c.setType(nType);
        c.setDecouvert(nDecouvert);
        c.setSolde(nSolde);
        c.setIdBanque(nIdBanque);
        c.setIdClient(nIdClient);

        this.compteDAO.ajouterCompte(c);
	}
}
