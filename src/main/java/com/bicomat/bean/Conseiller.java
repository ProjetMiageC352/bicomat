package com.bicomat.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe Conseiller.
 */
@Entity
@Table(name="conseiller")
public class Conseiller {

	/* **************************** */
	/*           ATTRIBUTS          */
	/* **************************** */
	
	/**
	 * Id du conseiller.
	 */
	@Id
	@Column(name="c_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id = 0;
	/**
	 * Nom du conseiller.
	 */
	@Column(name="c_nom")
	protected String nom = "";
	/**
	 * Prenom du conseiller.
	 */
	@Column(name="c_prenom")
	protected String prenom = "";
	/**
	 * Login du conseiller pour le compte agency.
	 */
	@Column(name="c_login_agency")
	protected String loginAgency = "";
	/**
	 * Mot de passe du conseiller pour le compte agency.
	 */
	@Column(name="c_password_agency")
	protected String passwordAgency = "";
	/**
	 * Id de la banque qui emploie le conseiller.
	 */
	@Column(name="b_id")
	protected int idBanque = 0;
	
	/* **************************** */
	/*         CONSTRUCTEURS        */
	/* **************************** */
	
    /**
     * Constructeur par défaut de la classe.
     */
    public Conseiller() {
    }
    /**
     * Constructeur de la classe.
     *
     * @param nomC Nom du conseiller
     * @param prenomConseiller Prénom du conseiller
     * @param loginAgencyC Login du conseiller pour le compte agency
     * @param passwordC Mot de passe du conseiller pour le compte agency
     * @param idBanqueC Id de la banque qui emploie le conseiller
     */
    public Conseiller(final String nomC, final String prenomC,
    		final String loginAgencyC, final String passwordAgencyC,
    		final int idBanqueC) {
    	this.nom = nomC;
    	this.prenom = prenomC;
    	this.loginAgency = loginAgencyC;
    	this.passwordAgency = passwordAgencyC;
    	this.idBanque = idBanqueC;
    }
    /**
     * Constructeur de la classe.
     *
     * @param idC Id du conseiller
     * @param nomC Nom du conseiller
     * @param prenomConseiller Prénom du conseiller
     * @param loginAgencyC Login du conseiller pour le compte agency
     * @param passwordC Mot de passe du conseiller pour le compte agency
     * @param idBanqueC Id de la banque qui emploie le conseiller
     */
    public Conseiller(final int idC, final String nomC, final String prenomC,
    		final String loginAgencyC, final String passwordAgencyC,
    		final int idBanqueC) {
    	this.id = idC;
    	this.nom = nomC;
    	this.prenom = prenomC;
    	this.loginAgency = loginAgencyC;
    	this.passwordAgency = passwordAgencyC;
    	this.idBanque = idBanqueC;
    }
    
    /* **************************** */
	/*            GETTERS           */
	/* **************************** */

    /**
     * Getter de l'id.
     *
     * @return id
     */
    public final int getId() {
        return id;
    }
    /**
     * Getter du nom.
     *
     * @return nom
     */
    public final String getNom() {
        return nom;
    }
    /**
     * Getter du prénom.
     *
     * @return prenom
     */
    public final String getPrenom() {
        return prenom;
    }
    /**
     * Getter du login agency.
     *
     * @return loginAgency
     */
    public final String getLoginAgency() {
        return loginAgency;
    }
    /**
     * Getter du password agency.
     *
     * @return passwordAgency
     */
    public final String getPasswordAgency() {
        return passwordAgency;
    }
    /**
     * Getter de l'id de la banque.
     *
     * @return idBanque
     */
    public final int getIdBanque() {
        return idBanque;
    }
    
    /* **************************** */
	/*            SETTERS           */
	/* **************************** */

    /**
     * Setter de l'id.
     *
     * @param idC Nouvel id
     */
    public final void setId(final int idC) {
        this.id = idC;
    }
    /**
     * Setter du nom.
     *
     * @param nomC Nouveau nom
     */
    public final void setNom(final String nomC) {
        this.nom = nomC;
    }
    /**
     * Setter du prenom.
     *
     * @param nomC Nouveau prénom
     */
    public final void setPrenom(final String prenomC) {
        this.prenom = prenomC;
    }
    /**
     * Setter du login agency.
     *
     * @param loginAgencyC Nouveau login
     */
    public final void setLoginAgency(final String loginAgencyC) {
        this.loginAgency = loginAgencyC;
    }
    /**
     * Setter du password agency.
     *
     * @param passwordAgencyC Nouveau login
     */
    public final void setPasswordAgency(final String passwordAgencyC) {
        this.passwordAgency = passwordAgencyC;
    }
    /**
     * Setter de l'id de la banque.
     *
     * @param idBanqueC Nouvel id de banque
     */
    public final void setIdBanque(final int idBanqueC) {
        this.idBanque = idBanqueC;
    }
	
    /* **************************** */
	/*           METHODES           */
	/* **************************** */
    
	@Override
	public String toString(){
		return "Conseiller [id = " + id + ", nom = " + nom + ", prenom = " + prenom
				+ ", login agnecy = " + loginAgency
				+ ", password agnecy = " + passwordAgency
				+ ", id banque = " + idBanque + "]";
	}
}
