package com.bicomat.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.bicomat.bean.Client;

@Repository
public class ClientDAO implements IClientDAO {
	
	@PersistenceContext
    private EntityManager entityManager;

	/**
	 * Ajoute une client.
	 *
	 * @param c Client à ajouter
	 */
	public void creerClient(Client c) {
		entityManager.persist(c);
	}
	/**
	 * Modifie une client.
	 *
	 * @param c Client à modifier
	 */
	/*public void modifierClient(Client c) {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaUpdate<Client> lCriteriaUpdate = lCriteriaBuilder.createCriteriaUpdate(Client.class);
        final Root<Client> lRoot = lCriteriaUpdate.from(Client.class);
        final Path<Client> lPath = lRoot.get("c_id_client");
        final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath, c.getId());
        lCriteriaUpdate.where(lExpression);
        lCriteriaUpdate.set("c_nom", c.getNom());
        lCriteriaUpdate.set("c_prenom", c.getPrenom());
        lCriteriaUpdate.set("c_adresse_mail", c.getAdresse_mail());
        lCriteriaUpdate.set("c_type_client", c.getType_client());
        final Query lQuery = entityManager.createQuery(lCriteriaUpdate);
        final int lRowCount = lQuery.executeUpdate();

        if (lRowCount != 1) {
            final org.hibernate.Query lHQuery = lQuery.unwrap(org.hibernate.Query.class);
            final String lSql = lHQuery.getQueryString();
            throw new RuntimeException("Nombre d'occurences (" + lRowCount + 
                    ") modifiées différent de 1 pour " + lSql);
        }
	}*/
	/**
	 * Supprime une client.
	 *
	 * @param id Id de la client à supprimer
	 */
	public void supprimerClient(int id) {
		final Client lClient = entityManager.getReference(Client.class, id);
        entityManager.remove(lClient);
	}

	/**
	 * Retourne la liste des clients.
	 *
	 * @return la liste des clients de la table
	 */
	public List<Client> listeClients() {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Client> lCriteriaQuery = lCriteriaBuilder.createQuery(Client.class);
        final Root<Client> lRoot = lCriteriaQuery.from(Client.class);
        lCriteriaQuery.select(lRoot);
        final TypedQuery<Client> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

        return lTypedQuery.getResultList();
	}

	

}
