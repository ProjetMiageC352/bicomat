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

import com.bicomat.bean.Conseiller;

@Repository
public class ConseillerDAO implements IConseillerDAO {
	
	@PersistenceContext
    private EntityManager entityManager;

	/**
	 * Ajoute un conseiller.
	 *
	 * @param c Conseiller à ajouter
	 */
	public void ajouterConseiller(Conseiller c) {
		entityManager.persist(c);
	}
	/**
	 * Modifie un conseiller.
	 *
	 * @param c Conseiller à modifier
	 */
	public void modifierConseiller(Conseiller c) {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaUpdate<Conseiller> lCriteriaUpdate = lCriteriaBuilder.createCriteriaUpdate(Conseiller.class);
        final Root<Conseiller> lRoot = lCriteriaUpdate.from(Conseiller.class);
        final Path<Conseiller> lPath = lRoot.get("c_id");
        final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath, c.getId());
        lCriteriaUpdate.where(lExpression);
        lCriteriaUpdate.set("c_nom", c.getNom());
        lCriteriaUpdate.set("c_prenom", c.getPrenom());
        lCriteriaUpdate.set("c_login_agency", c.getLoginAgency());
        lCriteriaUpdate.set("c_password_agency", c.getPasswordAgency());
        lCriteriaUpdate.set("b_id", c.getIdBanque());
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
	 * Supprime un conseiller.
	 *
	 * @param id Id du conseiller à supprimer
	 */
	public void supprimerConseiller(int id) {
		final Conseiller lConseiller = entityManager.getReference(Conseiller.class, id);
        entityManager.remove(lConseiller);
	}
	
	/**
	 * Vérifie si un conseiller existe pour un login et un mot de passe.
	 *
	 * @param login Login à vérifier
	 * @param password Password à vérifier
	 * @return existe Vrai si un conseiller existe avec le login et le mot de passe
	 */
	public boolean existeAvecLoginPassword(String login, String password) {
		boolean existe = false;
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Conseiller> lCriteriaQuery = lCriteriaBuilder.createQuery(Conseiller.class);
        final Root<Conseiller> lRoot = lCriteriaQuery.from(Conseiller.class);
        lCriteriaQuery.select(lRoot);
        lCriteriaQuery.where(lCriteriaBuilder.and(
        		lCriteriaBuilder.equal(lRoot.get("loginAgency"), login),
        		lCriteriaBuilder.equal(lRoot.get("passwordAgency"), password)
        		));

        TypedQuery<Conseiller> query = entityManager.createQuery(lCriteriaQuery);
        List<Conseiller> ListeConseillers = query.getResultList();
        
        if (!ListeConseillers.isEmpty()) {
        	existe = true;
        }
        return existe;
	}

	/**
	 * Retourne la liste des conseillers.
	 *
	 * @return la liste des conseillers de la table
	 */
	public List<Conseiller> listeConseillers() {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Conseiller> lCriteriaQuery = lCriteriaBuilder.createQuery(Conseiller.class);
        final Root<Conseiller> lRoot = lCriteriaQuery.from(Conseiller.class);
        lCriteriaQuery.select(lRoot);
        final TypedQuery<Conseiller> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

        return lTypedQuery.getResultList();
	}
	
}
