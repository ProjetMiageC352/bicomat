package com.bicomat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bicomat.bean.Client;
import com.bicomat.dao.IClientDAO;

@Service
public class ClientService implements IClientService {
	
	@Autowired
	private IClientDAO clientDAO;

	public void setClientDAO(IClientDAO nClientDAO) {
		this.clientDAO = nClientDAO;
	}

	/**
	 * Demande l'ajout une client.
	 *
	 * @param c Client à ajouter
	 */
	@Transactional
	public void creerClient(Client c) {
		this.clientDAO.creerClient(c);
	}
	/**
	 * Demande la modification d'une client.
	 *
	 * @param b Client à modifier
	 */
	@Transactional
	public void modifierClient(Client c) {
		this.clientDAO.modifierClient(c);
	}
	/**
	 * Demande la suppression d'une client.
	 *
	 * @param id Id de la client à supprimer
	 */
	@Transactional
	public void supprimerClient(int id) {
		this.clientDAO.supprimerClient(id);
	}

	/**
	 * Demande de vérifier si un Client existe pour un nom, prenom et numero de CB
	 * @param nom
	 * @param prenom
	 * @return
	 */
	/*public boolean existeAvecNomPrenomNumcarte(String nom, String prenom,String numcarte ) {
		return this.existeAvecNomPrenomNumcarte(nom, prenom, numcarte);
	}*/
	/**
	 * Demande de vérifier si un client existe pour un nom, prénom et numero de contrat
	 * 
	 * @param nom
	 * @param prenom
	 * @param num_contrat
	 * 
	 * @return vrai si le client existe
	 */
	public boolean existeAvecNomPrenomNumContrat(String nom, String prenom, int num_contrat) {
		return this.clientDAO.existeAvecNomPrenomNumContrat(nom, prenom, num_contrat);
	}
	
	/**
	 * Demande de vérifier si le client a un compte agency
	 * @param nom
	 * @param prenom
	 * @return
	 */
	public boolean verifieclientAgency(String nom, String prenom) {
		return this.verifieclientAgency(nom, prenom);
	}
	
	/**
	 * Demande la liste des clients.
	 *
	 * @return la liste des clients
	 */
	@Transactional(readOnly=true)
	public List<Client> listeClients() {
		return this.clientDAO.listeClients();
	}
	/**
	 * Demande de retourner un client pour un nom, prénom et numero de contrat.
	 * 
	 * @param nom
	 * @param prenom
	 * @param num_contrat
	 * @return le client
	 */
	@Transactional
	public Client getClientAvecNomPrenomNumContrat(String nom, String prenom, int num_contrat) {
		return this.clientDAO.getClientAvecNomPrenomNumContrat(nom, prenom, num_contrat);
	}
}
