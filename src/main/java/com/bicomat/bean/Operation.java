package com.bicomat.bean;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe Operation.
 */
@Entity
@Table(name="operation")
public class Operation {

	/* **************************** */
	/*           ATTRIBUTS          */
	/* **************************** */
	
	/**
	 * Id de l'opération.
	 */
	@Id
	@Column(name="o_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id = 0;
	/**
	 * Date de l'opération.
	 */
	@Column(name="o_date")
    protected Date date;
    /**
	 * Montant de l'opération.
	 */
	@Column(name="o_montant")
	protected double montant = 0;
	/**
	 * Type de l'opération.
	 */
	@Column(name="o_type")
	protected String type = "";
	/**
	 * Id de l'opération liée.
	 */
	//@Column(name="o_id_operation")
	//protected int idOperation = 0;
	/**
	 * Id du compte.
	 */
	@Column(name="c_id")
	protected int idCompte = 0;
	
	/* **************************** */
	/*         CONSTRUCTEURS        */
	/* **************************** */
	
	/**
     * Constructeur par défaut de la classe.
     */
    public Operation() {
    }
    /**
     * Constructeur de la classe.
     *
     * @param dateO Date de l'opération
     * @param montantO Montant de l'opération
     * @param typeO Type de l'opération
     * @param idCompte Id du compte
     */
    public Operation(final Date dateO, final double montantO,
    		final String typeO, final int idCompteO) {
    	this.date = dateO;
    	this.montant = montantO;
    	this.type = typeO;
    	//this.idOperation = idOperationO;
    	this.idCompte = idCompteO;
    }
    /**
     * Constructeur de la classe.
     *
     * @param idO Id de l'opération
     * @param dateO Date de l'opération
     * @param montantO Montant de l'opération
     * @param typeO Type de l'opération
     * @param idCompte Id du compte
     */
    public Operation(final int idO, final Date dateO, final double montantO,
    		final String typeO, final int idCompteO) {
    	this.id = idO;
    	this.date = dateO;
    	this.montant = montantO;
    	this.type = typeO;
    	//this.idOperation = idOperationO;
    	this.idCompte = idCompteO;
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
     * Getter de la date.
     *
     * @return date
     */
    public final Date getDate() {
        return date;
    }
    /**
     * Getter du montant.
     *
     * @return montant
     */
    public final double getMontant() {
        return montant;
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
     * Getter de l'id de l'opération liée.
     *
     * @return idOperation
     */
    /*public final int getIdOperation() {
        return idOperation;
    }*/
    /**
     * Getter de l'id du compte.
     *
     * @return idCompte
     */
    public final int getIdCompte() {
        return idCompte;
    }
    
    /* **************************** */
	/*            SETTERS           */
	/* **************************** */

    /**
     * Setter de l'id.
     *
     * @param idC Nouvel id
     */
    public final void setId(final int idO) {
        this.id = idO;
    }
    /**
     * Setter de la date.
     *
     * @param dateO Nouvelle date de l'opération
     */
    public final void setDate(final Date dateO) {
        this.date = dateO;
    }
    /**
     * Setter du montant.
     *
     * @param montantO Nouveau montant
     */
    public final void setMontant(final double montantO) {
        this.montant = montantO;
    }
    /**
     * Setter du type.
     *
     * @param typeO Nouveau type
     */
    public final void setType(final String typeO) {
        this.type = typeO;
    }
    /**
     * Setter de l'id de l'opération liée.
     *
     * @param idOperationO Id de la nouvelle opération liée
     */
    /*public final void setIdOperation(final int idOperationO) {
        this.idOperation = idOperationO;
    }*/
    /**
     * Setter de l'id du compte.
     *
     * @param idCompteO Id du nouveau compte
     */
    public final void setIdCompte(final int idCompteO) {
        this.idCompte = idCompteO;
    }
	
    /* **************************** */
	/*           METHODES           */
	/* **************************** */
	
	@Override
	public String toString(){
		return "Operation [id = " + id + ", date = " + date.toString() + ", montant = " + montant
				+ ", type = " + type + ", id compte = " + idCompte + "]";
	}
}
