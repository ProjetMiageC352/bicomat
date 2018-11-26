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

import com.bicomat.bean.Compte;

@Repository
public class CompteDAO implements ICompteDAO {
	
	@PersistenceContext
    private EntityManager entityManager;

	/**
	 * Ajoute un compte.
	 *
	 * @param c Compte à ajouter
	 */
	public void ajouterCompte(Compte c) {
		entityManager.persist(c);
	}
	/**
	 * Modifie un compte.
	 *
	 * @param c Compte à modifier
	 */
	public void modifierCompte(Compte c) {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaUpdate<Compte> lCriteriaUpdate = lCriteriaBuilder.createCriteriaUpdate(Compte.class);
        final Root<Compte> lRoot = lCriteriaUpdate.from(Compte.class);
        final Path<Compte> lPath = lRoot.get("id");
        final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath, c.getId());
        lCriteriaUpdate.where(lExpression);
        lCriteriaUpdate.set("type", c.getType());
        lCriteriaUpdate.set("decouvert", c.getDecouvert());
        lCriteriaUpdate.set("solde", c.getSolde());
        lCriteriaUpdate.set("actif", c.getActif());
        lCriteriaUpdate.set("idBanque", c.getIdBanque());
        lCriteriaUpdate.set("idClient", c.getIdClient());
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
	 * Supprime un compte.
	 *
	 * @param id Id du compte à supprimer
	 */
	public void supprimerCompte(int id) {
		final Compte lCompte = entityManager.getReference(Compte.class, id);
        entityManager.remove(lCompte);
	}

	/**
	 * Retourne la liste des comptes.
	 *
	 * @return la liste des comptes de la table
	 */
	public List<Compte> listeComptes() {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Compte> lCriteriaQuery = lCriteriaBuilder.createQuery(Compte.class);
        final Root<Compte> lRoot = lCriteriaQuery.from(Compte.class);
        lCriteriaQuery.select(lRoot);
        final TypedQuery<Compte> lTypedQuery = entityManager.createQuery(lCriteriaQuery);
        return lTypedQuery.getResultList();
	}
	/**
	 * Retourne la liste des comptes en fonction de l'id.
	 *
	 * @return la liste des comptes de la table
	 */
	public List<Compte> listeComptesparclient(int id) {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Compte> lCriteriaQuery = lCriteriaBuilder.createQuery(Compte.class);
        final Root<Compte> lRoot = lCriteriaQuery.from(Compte.class);
        lCriteriaQuery.select(lRoot);
        lCriteriaQuery.where(lCriteriaBuilder.and(
        		lCriteriaBuilder.equal(lRoot.get("idClient"), id)
        		));
        final TypedQuery<Compte> lTypedQuery = entityManager.createQuery(lCriteriaQuery);
        return lTypedQuery.getResultList();
	}
}
