package com.bicomat.dao;

import java.util.List;

import com.bicomat.bean.Client;

public interface IClientDAO {

	/**
	 * Ajoute une client.
	 *
	 * @param b Client à ajouter
	 */
	public void creerClient(Client c);
	/**
	 * Modifie une client.
	 *
	 * @param b Client à modifier
	 */
	/*public void modifierClient(Client c);
	/**
	 * Supprime une client.
	 *
	 * @param id Id de la client à supprimer
	 */
	public void supprimerClient(int id);
	
	/**
	 * Retourne la liste des clients.
	 *
	 * @return la liste des clients de la table
	 */
	public List<Client> listeClients();
}
