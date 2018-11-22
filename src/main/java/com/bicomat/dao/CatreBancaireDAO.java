package com.bicomat.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.bicomat.bean.CarteBancaire;

@Repository
public class CatreBancaireDAO implements ICarteBancaireDAO {
	
	@PersistenceContext
    private EntityManager entityManager;

	
	/**
	 * Retourne la liste des carteBancaires.
	 *
	 * @return la liste des carteBancaires de la table
	 */
	public List<CarteBancaire> listeCarteBancaires() {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<CarteBancaire> lCriteriaQuery = lCriteriaBuilder.createQuery(CarteBancaire.class);
        final Root<CarteBancaire> lRoot = lCriteriaQuery.from(CarteBancaire.class);
        lCriteriaQuery.select(lRoot);
        final TypedQuery<CarteBancaire> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

        return lTypedQuery.getResultList();
	}
}
