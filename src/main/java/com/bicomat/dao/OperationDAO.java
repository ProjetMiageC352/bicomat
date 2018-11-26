package com.bicomat.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.bicomat.bean.Compte;
import com.bicomat.bean.Operation;

@Repository
public class OperationDAO implements IOperationDAO {
	
	@PersistenceContext
    private EntityManager entityManager;

	/**
	 * Ajoute une opération.
	 *
	 * @param o Opération à ajouter
	 */
	public void ajouterOperation(Operation o) {
		entityManager.persist(o);
	}
	/**
	 * Modifie une opération.
	 *
	 * @param o Opération à modifier
	 */
	public void modifierOperation(Operation o) {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaUpdate<Operation> lCriteriaUpdate = lCriteriaBuilder.createCriteriaUpdate(Operation.class);
        final Root<Operation> lRoot = lCriteriaUpdate.from(Operation.class);
        final Path<Operation> lPath = lRoot.get("o_id");
        final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath, o.getId());
        lCriteriaUpdate.where(lExpression);
        lCriteriaUpdate.set("o_date", o.getDate());
        lCriteriaUpdate.set("o_montant", o.getMontant());
        lCriteriaUpdate.set("o_type", o.getType());
        //lCriteriaUpdate.set("o_id_operation", o.getIdOperation());
        lCriteriaUpdate.set("c_id", o.getIdCompte());
        final Query lQuery = entityManager.createQuery(lCriteriaUpdate);
        final int lRowCount = lQuery.executeUpdate();

        if (lRowCount != 1) {
            final org.hibernate.Query lHQuery = lQuery.unwrap(org.hibernate.Query.class);
            final String lSql = lHQuery.getQueryString();
            throw new RuntimeException("Nombre d'occurences (" + lRowCount + 
                    ") modifiées différent de 1 pour " + lSql);
        }
	}
	/**
	 * Supprime une opération.
	 *
	 * @param id Id de l'opération à supprimer
	 */
	public void supprimerOperation(int id) {
		final Operation lOperation = entityManager.getReference(Operation.class, id);
        entityManager.remove(lOperation);
	}

	/**
	 * Retourne la liste des opérations.
	 *
	 * @return la liste des opérations de la table
	 */
	public List<Operation> listeOperations() {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Operation> lCriteriaQuery = lCriteriaBuilder.createQuery(Operation.class);
        final Root<Operation> lRoot = lCriteriaQuery.from(Operation.class);
        lCriteriaQuery.select(lRoot);
        final TypedQuery<Operation> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

        return lTypedQuery.getResultList();
	}
	/**
	 * Retourne la liste des opérations en fonction de dates pour un compte.
	 *
	 * @param date1 Date de début du relevé
	 * @param date2 Date de fin du relevé
	 * @param compte Compte pour le relevé
	 * @return la liste des opérations
	 */
	public List<Operation> listeOperationsParDatesCompte(Date date1, Date date2, Compte compte) {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Operation> lCriteriaQuery = lCriteriaBuilder.createQuery(Operation.class);
        final Root<Operation> lRoot = lCriteriaQuery.from(Operation.class);
        lCriteriaQuery.select(lRoot);
        lCriteriaQuery.where(lCriteriaBuilder.and(
        		lCriteriaBuilder.between(lRoot.get("date").as(Date.class), date1, date2),
        		lCriteriaBuilder.equal(lRoot.get("idCompte"), compte.getId())
        		));
        
        final TypedQuery<Operation> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

        return lTypedQuery.getResultList();
	}
	
	/**
	 * Retourne la liste des opérations en fonction de dates pour un compte.
	 *
	
	 * @param compte Compte pour le relevé
	 * @return la liste des opérations
	 */
	public List<Operation> listeOperationsParCompte( int idcompte) {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Operation> lCriteriaQuery = lCriteriaBuilder.createQuery(Operation.class);
        final Root<Operation> lRoot = lCriteriaQuery.from(Operation.class);
        lCriteriaQuery.select(lRoot);
        lCriteriaQuery.where(lCriteriaBuilder.and(
        		lCriteriaBuilder.equal(lRoot.get("idCompte"), idcompte)
        		));
        
        final TypedQuery<Operation> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

        return lTypedQuery.getResultList();
	}
}
