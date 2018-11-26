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
	 * Modifie un client.
	 *
	 * @param b Client à modifier
	 */
	public void modifierClient(Client c);
	/**
	 * Supprime un client.
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
	/**
	 * Retourne un client pour un nom, prénom et numero de contrat.
	 * 
	 * @param nom
	 * @param prenom
	 * @param num_contrat
	 * @return le client
	 */
	public Client getClientAvecNomPrenomNumContrat(String nom, String prenom, int num_contrat);
	
	/**
	 * Vérifie si un client existe pour un nom, prenom et numero de CB
	 * 
	 * @param nom
	 * @param prenom
	 * @param numcarte
	 * @return vrai si le client existe
	 */
	//public boolean existeAvecNomPrenomNumcarte(String nom, String prenom,String numcarte );
	/**
	 * Vérifie si un client existe pour un nom, prénom et numero de contrat
	 * 
	 * @param nom
	 * @param prenom
	 * @param num_contrat
	 * 
	 * @return vrai si le client existe
	 */
	public boolean existeAvecNomPrenomNumContrat(String nom, String prenom, int num_contrat);
	/**
	 * Demande de vérifier si le client a un compte agency
	 * @param nom
	 * @param prenom
	 * @return
	 */
	public boolean verifieclientAgency(String nom, String prenom) ;
}
