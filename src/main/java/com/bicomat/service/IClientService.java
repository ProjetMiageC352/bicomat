package com.bicomat.service;

import java.util.List;

import com.bicomat.bean.Client;

public interface IClientService {

	/**
	 * Demande l'ajout d'un client.
	 *
	 * @param c Client à ajouter
	 */
	public void creerClient(Client c);
	/**
	 * Demande la modification d'un client.
	 *
	 * @param c Client à modifier
	 */
	public void modifierClient(Client c);
	/**
	 * Demande la suppression d'un client.
	 *
	 * @param id Id de la client à supprimer
	 */
	public void supprimerClient(int id);
	
	/**
	 * Demande de vérifier si un Client existe pour un nom, prenom et numero de CB.
	 * @param nom
	 * @param prenom
	 * @return
	 */
	//public boolean existeAvecNomPrenomNumcarte(String nom, String prenom,String numcarte );
	/**
	 * Demande de vérifier si un client existe pour un nom, prénom et numero de contrat.
	 * 
	 * @param nom
	 * @param prenom
	 * @param num_contrat
	 * @return vrai si le client existe
	 */
	public boolean existeAvecNomPrenomNumContrat(String nom, String prenom, int num_contrat);
	/**
	 * Demande de vérifier si le client a un compte agency.
	 * 
	 * @param nom
	 * @param prenom
	 * @param num_contrat
	 * @return vrai si le client possède un compte agency
	 */
	public boolean verifieclientAgency(String nom, String prenom);
	
	/**
	 * Demande la liste des clients.
	 *
	 * @return la liste des clients
	 */
	public List<Client> listeClients();
	/**
	 * Demande de retourner un client pour un nom, prénom et numero de contrat.
	 * 
	 * @param nom
	 * @param prenom
	 * @param num_contrat
	 * @return le client
	 */
	public Client getClientAvecNomPrenomNumContrat(String nom, String prenom, int num_contrat);
}
