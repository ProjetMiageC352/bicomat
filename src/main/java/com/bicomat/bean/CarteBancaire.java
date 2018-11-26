package com.bicomat.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="carteBancaire")
/** 
 * Classe carteBancaire
 */
public class CarteBancaire {
	/**
	 * Id carte
	 */
	@Id
	@Column(name="cb_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int idC;
	/**
	 * Numéro de la carte
	 */
	@Column(name="cb_num_carte")
	protected String num_carte;
	/**
	 * type de la carte
	 */
	@Column(name="cb_type_carte")
	protected String type_carte;
	/**
	 * Echéance de la carte
	 */
	@Column(name="cb_echeance")
	protected Date echeance;
	/**
	 *Id du client
	 */
	@Column(name="cb_idclient")
	protected int cb_idclient;
	
	/* **************************** */
	/*         CONSTRUCTEURS        */
	/* **************************** */	
	
	/**
	 * Default constructor
	 */
	public CarteBancaire () {
	}
	/**
     * Constructeur de la classe.
     *
     * @param numCB Numerao de la carte
     * @param typeCB Type de la carte
     * @param echeanceCB Echeance de la carte
     * @param idC Id du client propriétaire
     */
    public CarteBancaire(final String numCB, final String typeCB, final Date echeanceCB,
    		 final int idClientCB) {
        this.num_carte = numCB;
    	this.type_carte = typeCB;
    	this.echeance = echeanceCB;
    	this.cb_idclient = idClientCB;
    }
	/**
     * Constructeur de la classe.
     *
     * @param idCB Id de la carte
     * @param numCB Numerao de la carte
     * @param typeCB Type de la carte
     * @param echeanceCB Echeance de la carte
     * @param idC Id du client propriétaire
     */
    public CarteBancaire(final int idCB, final String numCB, final String typeCB,
    		final Date echeanceCB,  final int idClientCB) {
        this.idC = idCB;
        this.num_carte = numCB;
    	this.type_carte = typeCB;
    	this.echeance = echeanceCB;
    	this.cb_idclient = idClientCB;
    }	
	
	/* **************************** */
	/*            GETTERS           */
	/* **************************** */
	/**
	 * @return the idC
	 */
	public final int getIdC() {
		return idC;
	}
	
	/**
	 * @return the num_carte
	 */
	public final String getNum_carte() {
		return num_carte;
	}
	
	/**
	 * @return the type_carte
	 */
	public final String getType_carte() {
		return type_carte;
	}
	
	/**
	 * @return the echeance
	 */
	public final Date getEcheance() {
		return echeance;
	}
	
	
	
	/**
	 * @return the cb_idclient
	 */
	public final int getCb_idclient() {
		return cb_idclient;
	}


	/* **************************** */
	/*            SETTERS           */
	/* **************************** */
	/**
	 * @param idC the idC to set
	 */
	public final void setIdC(int idC) {
		this.idC = idC;
	}
	
	/**
	 * @param num_carte the num_carte to set
	 */
	public final void setNum_carte(String num_carte) {
		this.num_carte = num_carte;
	}
	
	/**
	 * @param type_carte the type_carte to set
	 */
	public final void setType_carte(String type_carte) {
		this.type_carte = type_carte;
	}
	
	/**
	 * @param echeance the echeance to set
	 */
	public final void setEcheance(Date echeance) {
		this.echeance = echeance;
	}
	
	

	/**
	 * @param cb_idclient the cb_idclient to set
	 */
	public final void setCb_idclient(int cb_idclient) {
		this.cb_idclient = cb_idclient;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CarteBancaire [idC=" + idC + ", num_carte=" + num_carte + ", type_carte=" + type_carte + ", echeance="
				+ echeance + ", cb_idclient=" + cb_idclient + "]";
	}
}
