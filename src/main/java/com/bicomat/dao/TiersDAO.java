package com.bicomat.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.bicomat.bean.Tiers;

@Repository
public class TiersDAO implements ITiersDAO {
	
	@PersistenceContext
    private EntityManager entityManager;

	/**
	 * Ajoute une tiers.
	 *
	 * @param c Tiers à ajouter
	 */
	public void creerTiers(Tiers t) {
		entityManager.persist(t);
	}
	

	/**
	 * Retourne la liste des tierss.
	 *
	 * @return la liste des tierss de la table
	 */
	public List<Tiers> listeTiers() {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Tiers> lCriteriaQuery = lCriteriaBuilder.createQuery(Tiers.class);
        final Root<Tiers> lRoot = lCriteriaQuery.from(Tiers.class);
        lCriteriaQuery.select(lRoot);
        final TypedQuery<Tiers> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

        return lTypedQuery.getResultList();
	}

	

}
