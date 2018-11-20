package com.bicomat.service;

import java.util.List;

import com.bicomat.bean.Client;

public interface IClientService {

	/**
	 * Demande l'ajout une client.
	 *
	 * @param c Client à ajouter
	 */
	public void ajouterClient(Client c);
	/**
	 * Demande la modification d'une client.
	 *
	 * @param c Client à modifier
	 */
	public void modifierClient(Client c);
	/**
	 * Demande la suppression d'une client.
	 *
	 * @param id Id de la client à supprimer
	 */
	public void supprimerClient(int id);
	
	/**
	 * Demande la liste des clients.
	 *
	 * @return la liste des clients
	 */
	public List<Client> listeClients();
	
	/**
	 * Demande la création d'une client.
	 */
	public void creerClient(final String nNom, final String nPrenom,final String nAdresse, final String nType);
}