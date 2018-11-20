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
	public void ajouterClient(Client c) {
		this.clientDAO.ajouterClient(c);
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
	 * Demande la liste des clients.
	 *
	 * @return la liste des clients
	 */
	@Transactional(readOnly=true)
	public List<Client> listeClients() {
		return this.clientDAO.listeClients();
	}
	
	/**
	 * Demande la création d'une client.
	 */
	@Transactional
	public void creerClient(final String nNom, final String nPrenom,final String nAdresse, final String nType) {
		final Client c = new Client();
        c.setNom(nNom);
        c.setPrenom(nPrenom);
        c.setAdresse_mail(nAdresse);
        c.setType_client(nType);
        this.clientDAO.ajouterClient(c);
	}
}
