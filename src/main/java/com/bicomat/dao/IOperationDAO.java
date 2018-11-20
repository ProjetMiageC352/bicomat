package com.bicomat.dao;

import java.util.List;

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
}
