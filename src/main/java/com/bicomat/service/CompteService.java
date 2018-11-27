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
	 * Demande la liste des comptespar client.
	 *
	 * @return la liste des comptes
	 */
	public List<Compte> listeComptesparclient(int id){
		return this.compteDAO.listeComptesparclient(id);
	}
	/**
	 * Demande de retourner un compte pour un id.
	 * 
	 * @param id
	 * @return le compte
	 */
	public Compte getCompteAvecId(int id) {
		return this.compteDAO.getCompteAvecId(id);
	}
	/**
	 * Cloturer un compte.
	 *
	 * @param c Compte à modifier
	 */
	/**
	 *Retourne la liste des comptes ouverts en fonction de l'id.
	 *
	 * @return la liste des comptes de la table
	 */
	public List<Compte> listeComptesOuvertparclient(int id){
		return this.compteDAO.listeComptesOuvertparclient(id);
	}
	
	/**
	 * Retourne un compte courant pour un id_client.
	 * 
	 * @param id_client
	 * @return le compte_courant
	 */
	public Compte getCompteIdCompteCourant(int id_client) {
		return this.compteDAO.getCompteIdCompteCourant(id_client);
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
