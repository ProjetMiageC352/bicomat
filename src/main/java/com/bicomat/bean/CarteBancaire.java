package com.bicomat.bean;

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
	protected int echeance;
	/**
	 * Code crypter de la carte
	 */
	@Column(name="cb_code_crypto")
	protected String code_crypto;
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
	public final int getEcheance() {
		return echeance;
	}
	
	/**
	 * @return the code_crypto
	 */
	public final String getCode_crypto() {
		return code_crypto;
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
	public final void setEcheance(int echeance) {
		this.echeance = echeance;
	}
	
	/**
	 * @param code_crypto the code_crypto to set
	 */
	public final void setCode_crypto(String code_crypto) {
		this.code_crypto = code_crypto;
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
				+ echeance + ", code_crypto=" + code_crypto + ", cb_idclient=" + cb_idclient + "]";
	}


	



}
