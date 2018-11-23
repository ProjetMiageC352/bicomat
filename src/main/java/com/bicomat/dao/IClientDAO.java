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
	 * Demande de vérifier si un Client existe pour un nom, prenom et numero de CB
	 * @param nom
	 * @param prenom
	 * @return
	 */
	public boolean existeAvecNomPrenomNumcarte(String nom, String prenom,String numcarte );
	/**
	 * Demande de vérifier si le client a un compte agency
	 * @param nom
	 * @param prenom
	 * @return
	 */
	public boolean verifieclientAgency(String nom, String prenom) ;
	/**
	 * Retourne la liste des clients.
	 *
	 * @return la liste des clients de la table
	 */
	public List<Client> listeClients();
}
