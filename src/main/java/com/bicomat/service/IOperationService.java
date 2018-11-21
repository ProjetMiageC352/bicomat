package com.bicomat.service;

import java.sql.Date;
import java.util.List;

import com.bicomat.bean.Operation;

public interface IOperationService {

	/**
	 * Demande l'ajout d'une opération.
	 *
	 * @param o Opération à ajouter
	 */
	public void ajouterOperation(Operation o);
	/**
	 * Demande la modification d'une opération.
	 *
	 * @param o Opération à modifier
	 */
	public void modifierOperation(Operation o);
	/**
	 * Demande la suppression d'une opération.
	 *
	 * @param id Id de l'opération à supprimer
	 */
	public void supprimerOperation(int id);
	
	/**
	 * Demande la liste des opérations.
	 *
	 * @return la liste des opérations
	 */
	public List<Operation> listeOperations();
	
	/**
	 * Demande la création d'une opération.
	 *
	 * @param nDate Date de la nouvelle opération
	 * @param nMontant Montant de la nouvelle opération
	 * @param nType Type de la nouvelle opération
	 * @param nIdOperation Id de l'opération liée à la nouvelle opération
	 * @param nIdCompte Id du compte de la nouvelle opération
	 */
	public void creerOperation(final Date nDate, final double nMontant,
			final String nType, final int nIdOperation, final int nIdCompte);
}
