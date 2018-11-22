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
	private int id;
	/**
	 * Nom du tiers
	 */
	@Column(name="t_nom")
	private String nom;
	/**
	 * Prenom du tiers
	 */
	@Column(name="t_prenom")
	private String prenom;
	/**
	 * Numéro de compte du tiers
	 */
	@Column(name="t_num_compte")
	private int numCompte;
	/**
	 * Id du client associé
	 */
	@Column(name="t_id_client")
	private int idclientT;
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
     * @param nomT
     * @param prenomT
     * @param numCompteT
     * @param id_clientT
     * @param actifT
     */
    public Tiers(String nomT,String prenomT,int numCompteT, int id_clientT,boolean actifT) {
    	this.nom=nomT;
    	this.prenom=prenomT;
    	this.numCompte=numCompteT;
    	this.idclientT=id_clientT;
    	this.actif=actifT;
    }
    
   
    
	
	/* **************************** */
	/*            GETTERS           */
	/* **************************** */
    /**
	 * @return the id
	 */
	public final int getId() {
		return id;
	}
	/**
	 * @return the nomT
	 */
	public final String getNom() {
		return nom;
	}
	/**
	 * @return the prenomT
	 */
	public final String getPrenom() {
		return prenom;
	}
    /**
	 * @return the numCompte
	 */
	public final int getNumCompte() {
		return numCompte;
	}
	/**
	 * @return the idclientT
	 */
	public final int getIdclientT() {
		return idclientT;
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
	public final void setId(int id) {
		this.id = id;
	}
	/**
	 * @param nomT the nomT to set
	 */
	public final void setNom(String nomT) {
		this.nom = nomT;
	}

	/**
	 * @param prenomT the prenomT to set
	 */
	public final void setPrenom(String prenomT) {
		this.prenom = prenomT;
	}
	/**
	 * @param numCompte the numCompte to set
	 */
	public final void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	/**
	 * @param idclientT the idclientT to set
	 */
	public final void setIdclientT(int idclientT) {
		this.idclientT = idclientT;
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
		return "Tiers [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", numCompte=" + numCompte
				+ ", idclientT=" + idclientT + ", actif=" + actif + "]";
	}   
}