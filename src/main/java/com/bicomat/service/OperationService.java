package com.bicomat.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bicomat.bean.Compte;
import com.bicomat.bean.Operation;
import com.bicomat.dao.IOperationDAO;

@Service
public class OperationService implements IOperationService {
	
	@Autowired
	private IOperationDAO operationDAO;

	public void setOperationDAO(IOperationDAO nOperationDAO) {
		this.operationDAO = nOperationDAO;
	}

	/**
	 * Demande l'ajout d'une opération.
	 *
	 * @param o Opération à ajouter
	 */
	@Transactional
	public void ajouterOperation(Operation o) {
		this.operationDAO.ajouterOperation(o);
	}
	/**
	 * Demande la modification d'une opération.
	 *
	 * @param o Opération à modifier
	 */
	@Transactional
	public void modifierOperation(Operation o) {
		this.operationDAO.modifierOperation(o);
	}
	/**
	 * Demande la suppression d'une opération.
	 *
	 * @param id Id de l'opération à supprimer
	 */
	@Transactional
	public void supprimerOperation(int id) {
		this.operationDAO.supprimerOperation(id);
	}

	/**
	 * Demande la liste des opérations.
	 *
	 * @return la liste des opérations
	 */
	@Transactional(readOnly=true)
	public List<Operation> listeOperations() {
		return this.operationDAO.listeOperations();
	}
	/**
	 * Demande la liste des opérations en fonction de dates pour un compte.
	 * 
	 * @param date1 Date de début du relevé
	 * @param date2 Date de fin du relevé
	 * @param compte Compte pour le relevé
	 * @return la liste des opérations
	 */
	@Transactional(readOnly=true)
	public List<Operation> listeOperationsParDatesCompte(Date date1, Date date2, Compte compte) {
		return this.operationDAO.listeOperationsParDatesCompte(date1,date2, compte);
	}
	/**
	 * Demande la liste des opérations  pour un compte.
	 * 
	
	 * @param compte Compte pour le relevé
	 * @return la liste des opérations
	 */
	@Transactional(readOnly=true)
	public List<Operation> listeOperationsParCompte( int idcompte) {
		return this.operationDAO.listeOperationsParCompte( idcompte);
	}
	/**
	 * Demande la création d'une opération.
	 *
	 * @param nDate Date de la nouvelle opération
	 * @param nMontant Montant de la nouvelle opération
	 * @param nType Type de la nouvelle opération
	 * @param nIdOperation Id de l'opération liée à la nouvelle opération
	 * @param nIdCompte Id du compte de la nouvelle opération
	 */
	@Transactional
	public void creerOperation(final Date nDate, final double nMontant,
			final String nType, final int nIdOperation, final int nIdCompte) {
		final Operation o = new Operation();
        o.setDate(nDate);
        o.setMontant(nMontant);
        o.setType(nType);
        //o.setIdOperation(nIdOperation);
        o.setIdCompte(nIdCompte);

        this.operationDAO.ajouterOperation(o);
	}
}
