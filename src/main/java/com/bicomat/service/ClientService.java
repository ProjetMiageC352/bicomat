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
	 * Demande la liste des clients.
	 *
	 * @return la liste des clients
	 */
	@Transactional(readOnly=true)
	public List<Client> listeClients() {
		return this.clientDAO.listeClients();
	}
	
	
}
