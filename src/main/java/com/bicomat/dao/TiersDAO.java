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
	
	/**
	 * Demande de vérifier si un Tiers existe pour un nom, prenom et numero de compte
	 * @param nom
	 * @param prenom
	 * @param numcompte
	 * @return
	 */
	public boolean existeAvecNomPrenomNumCompte(String nom, String prenom,String numcompte,int idclient ) {
		boolean existe = false;
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Tiers> lCriteriaQuery = lCriteriaBuilder.createQuery(Tiers.class);
		final Root<Tiers> lRoot = lCriteriaQuery.from(Tiers.class);
		lCriteriaQuery.select(lRoot);
		lCriteriaQuery.where(lCriteriaBuilder.and(
        		lCriteriaBuilder.equal(lRoot.get("nom"), nom),
        		lCriteriaBuilder.equal(lRoot.get("prenom"), prenom),
        		lCriteriaBuilder.equal(lRoot.get("numCompte"), numcompte),
        		lCriteriaBuilder.equal(lRoot.get("idclientT"), idclient)
        		));
		TypedQuery<Tiers> query = entityManager.createQuery(lCriteriaQuery);
		List<Tiers> ListeTiers = query.getResultList();
	
		if (!ListeTiers.isEmpty()) {
	    	existe = true;
	    }
	    return existe;
	}
	
}