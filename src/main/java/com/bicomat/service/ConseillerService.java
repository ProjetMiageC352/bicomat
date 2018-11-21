package com.bicomat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bicomat.bean.Conseiller;
import com.bicomat.dao.IConseillerDAO;

@Service
public class ConseillerService implements IConseillerService {
	
	@Autowired
	private IConseillerDAO conseillerDAO;

	public void setConseillerDAO(IConseillerDAO nConseillerDAO) {
		this.conseillerDAO = nConseillerDAO;
	}

	/**
	 * Demande l'ajout d'un conseiller.
	 *
	 * @param c Conseiller à ajouter
	 */
	@Transactional
	public void ajouterConseiller(Conseiller c) {
		this.conseillerDAO.ajouterConseiller(c);
	}
	/**
	 * Demande la modification d'un conseiller.
	 *
	 * @param c Conseiller à modifier
	 */
	@Transactional
	public void modifierConseiller(Conseiller c) {
		this.conseillerDAO.modifierConseiller(c);
	}
	/**
	 * Demande la suppression d'un conseiller.
	 *
	 * @param id Id du conseiller à supprimer
	 */
	@Transactional
	public void supprimerConseiller(int id) {
		this.conseillerDAO.supprimerConseiller(id);
	}
	
	/**
	 * Demande de vérifier si un conseiller existe pour un login et un mot de passe.
	 *
	 * @param login Login à vérifier
	 * @param password Password à vérifier
	 * @return existe Vrai si un conseiller existe avec le login et le mot de passe
	 */
	public boolean existeAvecLoginPassword(String login, String password) {
		return this.conseillerDAO.existeAvecLoginPassword(login, password);
	}

	/**
	 * Demande la liste des conseillers.
	 *
	 * @return la liste des conseillers
	 */
	@Transactional(readOnly=true)
	public List<Conseiller> listeConseillers() {
		return this.conseillerDAO.listeConseillers();
	}
	
	/**
	 * Demande la création d'un conseiller.
	 *
	 * @param nNom Nom du nouveau conseiller
	 * @param nPrenom Prenom du nouveau conseiller
	 * @param nLoginAgency Login agency du nouveau conseiller
	 * @param nPasswordAgency Mot de passe agency du nouveau conseiller
	 * @param nIdBanque Id de la banque du nouveau conseiller
	 */
	@Transactional
	public void creerConseiller(final String nNom, final String nPrenom,
			final String nLoginAgency, final String nPasswordAgency,
    		final int nIdBanque) {
		final Conseiller c = new Conseiller();
        c.setNom(nNom);
        c.setPrenom(nPrenom);
        c.setLoginAgency(nLoginAgency);
        c.setPasswordAgency(nPasswordAgency);
        c.setIdBanque(nIdBanque);

        this.conseillerDAO.ajouterConseiller(c);
	}
}
