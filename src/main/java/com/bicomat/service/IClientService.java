package com.bicomat.service;

import java.util.List;

import com.bicomat.bean.Client;

public interface IClientService {

	/**
	 * Demande l'ajout une client.
	 *
	 * @param c Client à ajouter
	 */
	public void creerClient(Client c);
	/**
	 * Demande la modification d'une client.
	 *
	 * @param c Client à modifier
	 */
	//public void modifierClient(Client c);
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
}
