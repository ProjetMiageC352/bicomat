package com.bicomat.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe Compte.
 */
@Entity
@Table(name="compte")
public class Compte {

	/* **************************** */
	/*           ATTRIBUTS          */
	/* **************************** */
	
	/**
	 * Id du compte / numéro de compte.
	 */
	@Id
	@Column(name="c_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id = 0;
	/**
	 * Type de compte.
	 */
	@Column(name="c_type")
	protected String type = "";
	/**
	 * Découvert autorisé pour le compte.
	 */
	@Column(name="c_decouvert")
	protected boolean decouvert = false;
	/**
	 * Solde du compte.
	 */
	@Column(name="c_solde")
	protected double solde = 0;
	/**
	 * Compte actif ou cloturé.
	 */
	@Column(name="c_actif")
	protected boolean actif = true;
	/**
	 * Id de la banque de rattachement.
	 */
	@Column(name="b_id")
	protected int idBanque = 0;
	/**
	 * Id du propriétaire du compte.
	 */
	@Column(name="c_id_client")
	protected int idClient = 0;
	
	/* **************************** */
	/*         CONSTRUCTEURS        */
	/* **************************** */
	
	/**
     * Constructeur par défaut de la classe.
     */
    public Compte() {
    }
    /**
     * Constructeur de la classe.
     *
     * @param typeC Type de compte
     * @param decouvertC Découvert autorisé pour le compte
     * @param soldeC Solde du compte
     * @param actifC Compte actif ou clôturé
     * @param idBanqueC Id de la banque qui gère le compte
     * @param idClientC Id du client qui possède le compte
     */
    public Compte(final String typeC, final boolean decouvertC,
    		final double soldeC, final boolean actifC, final int idBanqueC,
    		final int idClientC) {
    	this.type = typeC;
    	this.decouvert = decouvertC;
    	this.solde = soldeC;
    	this.actif = actifC;
    	this.idBanque = idBanqueC;
    	this.idClient = idClientC;
    }
    /**
     * Constructeur de la classe.
     *
     * @param idC Numéro de compte
     * @param typeC Type de compte
     * @param decouvertC Découvert autorisé pour le compte
     * @param soldeC Solde du compte
     * @param actifC Compte actif ou clôturé
     * @param idBanqueC Id de la banque qui gère le compte
     * @param idClientC Id du client qui possède le compte
     */
    public Compte(final int idC, final String typeC, final boolean decouvertC,
    		final double soldeC, final boolean actifC, final int idBanqueC,
    		final int idClientC) {
    	this.id = idC;
    	this.type = typeC;
    	this.decouvert = decouvertC;
    	this.solde = soldeC;
    	this.actif = actifC;
    	this.idBanque = idBanqueC;
    	this.idClient = idClientC;
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
     * Getter du type.
     *
     * @return type
     */
    public final String getType() {
        return type;
    }
    /**
     * Getter du découvert autorisé.
     *
     * @return decouvert
     */
    public final boolean getDecouvert() {
        return decouvert;
    }
    /**
     * Getter du solde.
     *
     * @return solde
     */
    public final double getSolde() {
        return solde;
    }
    /**
     * Getter de l'état du compte : actif ou clôturé.
     *
     * @return actif
     */
    public final boolean getActif() {
        return actif;
    }
    /**
     * Getter de l'id de la banque.
     *
     * @return idBanque
     */
    public final int getIdBanque() {
        return idBanque;
    }
    /**
     * Getter de l'id du client.
     *
     * @return idClient
     */
    public final int getIdClient() {
        return idClient;
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
     * Setter du type.
     *
     * @param typeC Nouveau type
     */
    public final void setType(final String typeC) {
        this.type = typeC;
    }
    /**
     * Setter du découvert autorisé.
     *
     * @param decouvertC Nouveau découvert autorisé
     */
    public final void setDecouvert(final boolean decouvertC) {
        this.decouvert = decouvertC;
    }
    /**
     * Setter du solde.
     *
     * @param soldeC Nouveau solde
     */
    public final void setSolde(final double soldeC) {
        this.solde = soldeC;
    }
    /**
     * Setter de l'état du compte : actif ou clôturé.
     *
     * @param actifC Nouvel état
     */
    public final void setActif(final boolean actifC) {
        this.actif = actifC;
    }
    /**
     * Setter de l'id de la banque.
     *
     * @param idBanqueC Nouvel id de la banque
     */
    public final void setIdBanque(final int idBanqueC) {
        this.idBanque = idBanqueC;
    }
    /**
     * Setter de l'id du client.
     *
     * @param idClientC Nouvel id du client
     */
    public final void setIdClient(final int idClientC) {
        this.idClient = idClientC;
    }
	
    /* **************************** */
	/*           METHODES           */
	/* **************************** */
    
    @Override
	public String toString(){
		return "Compte [id = " + id + ", type = " + type + ", découvert = " + decouvert
				+ ", solde = " + solde
				+ ", id banque = " + idBanque
				+ ", id client = " + idClient + "]";
	}
}
