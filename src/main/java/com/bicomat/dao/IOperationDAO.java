package com.bicomat.dao;

import java.sql.Date;
import java.util.List;

import com.bicomat.bean.Compte;
import com.bicomat.bean.Operation;

public interface IOperationDAO {

	/**
	 * Ajoute une opération.
	 *
	 * @param o Opération à ajouter
	 */
	public void ajouterOperation(Operation o);
	/**
	 * Modifie une opération.
	 *
	 * @param o Operation à modifier
	 */
	public void modifierOperation(Operation o);
	/**
	 * Supprime une opération.
	 *
	 * @param id Id de l'opération à supprimer
	 */
	public void supprimerOperation(int id);
	
	/**
	 * Retourne la liste des opérations.
	 *
	 * @return la liste des opérations de la table
	 */
	public List<Operation> listeOperations();
	/**
	 * Retourne la liste des opérations en fonction de dates pour un compte.
	 *
	 * @param date1 Date de début du relevé
	 * @param date2 Date de fin du relevé
	 * @param compte Compte pour le relevé
	 * @return la liste des opérations
	 */
	public List<Operation> listeOperationsParDatesCompte(Date date1, Date date2, Compte compte);
	/**
	 * Retourne la liste des opérations en fonction  pour un compte.
	 *
	
	 * @param compte Compte pour le relevé
	 * @return la liste des opérations
	 */
	public List<Operation> listeOperationsParCompte( int idcompte);
}
