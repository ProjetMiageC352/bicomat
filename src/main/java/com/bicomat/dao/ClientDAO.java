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

import com.bicomat.bean.Client;

@Repository
public class ClientDAO implements IClientDAO {
	
	@PersistenceContext
    private EntityManager entityManager;

	/**
	 * Ajoute un client.
	 *
	 * @param c Client à ajouter
	 */
	public void creerClient(Client c) {
		entityManager.persist(c);
	}
		
	/**
	 * Modifie un client.
	 *
	 * @param c Client à modifier
	 */
	public void modifierClient(Client c) {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaUpdate<Client> lCriteriaUpdate = lCriteriaBuilder.createCriteriaUpdate(Client.class);
        final Root<Client> lRoot = lCriteriaUpdate.from(Client.class);
        final Path<Client> lPath = lRoot.get("id");
        final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath, c.getId());
        lCriteriaUpdate.where(lExpression);
        lCriteriaUpdate.set("nom", c.getNom());
        lCriteriaUpdate.set("prenom", c.getPrenom());
        lCriteriaUpdate.set("adresse_mail", c.getAdresse_mail());
        lCriteriaUpdate.set("tel_client", c.getTel_client());
        lCriteriaUpdate.set("num_contrat", c.getNum_contrat());
        lCriteriaUpdate.set("id_conseiller", c.getId_conseiller());
        lCriteriaUpdate.set("login", c.getLogin());
        lCriteriaUpdate.set("password", c.getPassword());
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
	 * Supprime un client.
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
        lCriteriaQuery.orderBy(lCriteriaBuilder.asc(lRoot.get("nom")));
        
        final TypedQuery<Client> lTypedQuery = entityManager.createQuery(lCriteriaQuery);
        return lTypedQuery.getResultList();
	}
	/**
	 * Retourne un client pour un nom, prénom et numero de contrat.
	 * 
	 * @param nom
	 * @param prenom
	 * @param num_contrat
	 * @return le client
	 */
	public Client getClientAvecNomPrenomNumContrat(String nom, String prenom, int num_contrat) {
		Client client = new Client();
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Client> lCriteriaQuery = lCriteriaBuilder.createQuery(Client.class);
        final Root<Client> lRoot = lCriteriaQuery.from(Client.class);
        lCriteriaQuery.select(lRoot);
        lCriteriaQuery.where(lCriteriaBuilder.and(
        		lCriteriaBuilder.equal(lRoot.get("nom"), nom),
        		lCriteriaBuilder.equal(lRoot.get("prenom"), prenom),
        		lCriteriaBuilder.equal(lRoot.get("num_contrat"), num_contrat)
        		));

        TypedQuery<Client> query = entityManager.createQuery(lCriteriaQuery);
        List<Client> ListeClients = query.getResultList();
        
        if (!ListeClients.isEmpty()) {
        	client = ListeClients.get(0);
        }
        return client;
	}

	/**
	 * Vérifie si un client existe pour un nom, prenom et numero de CB
	 * 
	 * @param nom
	 * @param prenom
	 * @param numcarte
	 * @return vrai si le client existe
	 */
	/*public boolean existeAvecNomPrenomNumcarte(String nom, String prenom,String numcarte ) {
		boolean existe = false;
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Client> lCriteriaQuery = lCriteriaBuilder.createQuery(Client.class);
		final Root<Client> lRoot = lCriteriaQuery.from(Client.class);
		lCriteriaQuery.multiselect(lRoot.get("id"));
		
		lCriteriaQuery.where(lCriteriaBuilder.and(
        		lCriteriaBuilder.equal(lRoot.get("nom"), nom),
        		lCriteriaBuilder.equal(lRoot.get("prenom"), prenom)        		
        		));
		TypedQuery<Client> query = entityManager.createQuery(lCriteriaQuery);
		List<Client> ListeClient = query.getResultList();
	
		if (!ListeClient.isEmpty()) {
			int Id_client = query.getSingleResult().getId();
			final CriteriaBuilder lCriteriaBuilder2 = entityManager.getCriteriaBuilder();
			final CriteriaQuery<CarteBancaire> lCriteriaQuery2 = lCriteriaBuilder2.createQuery(CarteBancaire.class);
			final Root<CarteBancaire> lRoot2 = lCriteriaQuery2.from(CarteBancaire.class);
			lCriteriaQuery2.select(lRoot2);
			lCriteriaQuery2.where(lCriteriaBuilder2.and(
	        		lCriteriaBuilder2.equal(lRoot2.get("idC"), Id_client)       		
	        		));
			TypedQuery<CarteBancaire> query2 = entityManager.createQuery(lCriteriaQuery2);
	    	List<CarteBancaire> ListeCarteBancaire = query2.getResultList();
	    	if (!ListeCarteBancaire.isEmpty()) {
	    	existe = true;
	    	}
	    	 return existe;
	    }
	    return existe;
	}*/
	/**
	 * Vérifie si un client existe pour un nom, prénom et numero de contrat
	 * 
	 * @param nom
	 * @param prenom
	 * @param num_contrat
	 * 
	 * @return vrai si le client existe
	 */
	public boolean existeAvecNomPrenomNumContrat(String nom, String prenom, int num_contrat) {
		boolean existe = false;
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Client> lCriteriaQuery = lCriteriaBuilder.createQuery(Client.class);
        final Root<Client> lRoot = lCriteriaQuery.from(Client.class);
        lCriteriaQuery.select(lRoot);
        lCriteriaQuery.where(lCriteriaBuilder.and(
        		lCriteriaBuilder.equal(lRoot.get("nom"), nom),
        		lCriteriaBuilder.equal(lRoot.get("prenom"), prenom),
        		lCriteriaBuilder.equal(lRoot.get("num_contrat"), num_contrat)
        		));

        TypedQuery<Client> query = entityManager.createQuery(lCriteriaQuery);
        List<Client> ListeClients = query.getResultList();
        
        if (!ListeClients.isEmpty()) {
        	existe = true;
        }
        return existe;
	}
	
	/**
	 * Demande de vérifier si le client a un compte agency
	 * 
	 * @param nom
	 * @param prenom
	 * @return
	 */
	public boolean verifieclientAgency(String nom, String prenom) {
		boolean compteagency = false;
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Client> lCriteriaQuery = lCriteriaBuilder.createQuery(Client.class);
		final Root<Client> lRoot = lCriteriaQuery.from(Client.class);
		lCriteriaQuery.multiselect(lRoot.get("login"));
		lCriteriaQuery.where(lCriteriaBuilder.and(
        		lCriteriaBuilder.equal(lRoot.get("nom"), nom),
        		lCriteriaBuilder.equal(lRoot.get("prenom"), prenom)
        		
        		));
		TypedQuery<Client> query = entityManager.createQuery(lCriteriaQuery);
		String LoginClient = query.getSingleResult().getLogin();
	
		if (LoginClient !=null) {
			compteagency = true;
	    }
	    return compteagency;
	}

}
