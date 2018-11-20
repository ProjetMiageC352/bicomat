package com.bicomat.dao;

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

import com.bicomat.bean.Banque;

@Repository
public class BanqueDAO implements IBanqueDAO {
	
	@PersistenceContext
    private EntityManager entityManager;

	/**
	 * Ajoute une banque.
	 *
	 * @param b Banque à ajouter
	 */
	public void ajouterBanque(Banque b) {
		entityManager.persist(b);
	}
	/**
	 * Modifie une banque.
	 *
	 * @param b Banque à modifier
	 */
	public void modifierBanque(Banque b) {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaUpdate<Banque> lCriteriaUpdate = lCriteriaBuilder.createCriteriaUpdate(Banque.class);
        final Root<Banque> lRoot = lCriteriaUpdate.from(Banque.class);
        final Path<Banque> lPath = lRoot.get("b_id");
        final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath, b.getId());
        lCriteriaUpdate.where(lExpression);
        lCriteriaUpdate.set("b_nom", b.getNom());
        lCriteriaUpdate.set("b_adresse", b.getAdresse());
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
	 * Supprime une banque.
	 *
	 * @param id Id de la banque à supprimer
	 */
	public void supprimerBanque(int id) {
		final Banque lBanque = entityManager.getReference(Banque.class, id);
        entityManager.remove(lBanque);
	}

	/**
	 * Retourne la liste des banques.
	 *
	 * @return la liste des banques de la table
	 */
	public List<Banque> listeBanques() {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Banque> lCriteriaQuery = lCriteriaBuilder.createQuery(Banque.class);
        final Root<Banque> lRoot = lCriteriaQuery.from(Banque.class);
        lCriteriaQuery.select(lRoot);
        final TypedQuery<Banque> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

        return lTypedQuery.getResultList();
	}
}
