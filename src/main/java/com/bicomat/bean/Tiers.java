package com.bicomat.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tiers")
/** 
 * Classe tiers
 */
public class Tiers  {
	
	@Id
	@Column(name="t_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idT;
	
	/**
	 * Numéro de compte du client
	 */
	@Column(name="t_num_compte")
	private int numCompte;
	
	/**
	 * Client actif?
	 */
	@Column(name="t_actif")
	private boolean actif;

	/* **************************** */
	/*         CONSTRUCTEURS        */
	/* **************************** */	
	
	
	/**
     * Default constructor
     */
    public Tiers() {
    	
    }

    /**
     * Constructeur de la classe.
     */
	 /**
     * @param id_T
     * @param numCompteT
     * @param actifT
     */
    public Tiers(final int numCompteT, final boolean actifT) {
    	
    	this.numCompte=numCompteT;
    	this.actif=actifT;
    }
    
   
    
	
	/* **************************** */
	/*            GETTERS           */
	/* **************************** */
    /**
	 * @return the id
	 */
	public final int getIdT() {
		return idT;
	}
	
    /**
	 * @return the numCompte
	 */
	public final int getNumCompte() {
		return numCompte;
	}
	/**
	 * @return the actif
	 */
	public final boolean isActif() {
		return actif;
	}
	
	/* **************************** */
	/*            SETTERS           */
	/* **************************** */
	/**
	 * @param id the id to set
	 */
	public final void setIdT(int id) {
		this.idT = id;
	}
	/**
	 * @param numCompte the numCompte to set
	 */
	public final void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	/**
	 * @param actif the actif to set
	 */
	public final void setActif(boolean actif) {
		this.actif = actif;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tiers [idT=" + idT + ", numCompte=" + numCompte + ", actif=" + actif + "]";
	}
	
   
}