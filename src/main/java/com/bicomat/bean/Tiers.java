package com.bicomat.bean;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import com.mysql.jdbc.Util;

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
	 * Num�ro de compte du tiers
	 */
	@Column(name="t_num_compte")
	private String numCompte;
	/**
	 * Id du client associ�
	 */
	@Column(name="t_id_client")
	private int idclientT;
	/**
	 * Client actif?
	 */
	@Column(name="	t_date_creation")
	private Date date_creation;

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
     * 
     * @param nomT
     * @param prenomT
     * @param numCompteT
     * @param id_clientT
     * @param dateT
     */
    public Tiers(String nomT,String prenomT,String numCompteT, int id_clientT,Date dateT) {
    	this.nom=nomT;
    	this.prenom=prenomT;
    	this.numCompte=numCompteT;
    	this.idclientT=id_clientT;
    	this.date_creation=dateT;
    }
    /**
     * Constructeur de la classe.
     * 
     * @param idT
     * @param nomT
     * @param prenomT
     * @param numCompteT
     * @param id_clientT
     * @param dateT
     */
    public Tiers(int idT, String nomT, String prenomT, String numCompteT,
    		int id_clientT, Date dateT) {
    	this.id = idT;
    	this.nom = nomT;
    	this.prenom = prenomT;
    	this.numCompte = numCompteT;
    	this.idclientT = id_clientT;
    	this.date_creation = dateT;
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
	public final String getNumCompte() {
		return numCompte;
	}
	/**
	 * @return the idclientT
	 */
	public final int getIdclientT() {
		return idclientT;
	}
	/**
	 * @return the date_creation
	 */
	public final Date getDate_creation() {
		return date_creation;
	}
	
	/* **************************** */
	/*            SETTERS           */
	/* **************************** */
	/**
	 * @param idT the id to set
	 */
	public final void setId(int idT) {
		this.id = idT;
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
	 * @param numCompteT the numCompte to set
	 */
	public final void setNumCompte(String numCompteT) {
		this.numCompte = numCompteT;
	}
	/**
	 * @param idclientT the idclientT to set
	 */
	public final void setIdclientT(int idclientT) {
		this.idclientT = idclientT;
	}
	/**
	 * @param date_creation the date_creation to set
	 */
	public final void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	
	/* **************************** */
	/*           METHODES           */
	/* **************************** */

	/**
     * Teste si le tiers est actif.
     * 
     * @return vrai si le tiers à été créé il y a plus d'un jour
     */
    
    public final boolean isActif() {
    	boolean actif = true;
    	
    	LocalDate lDateJour = LocalDate.now();
    	LocalDate lDateActivation = date_creation.toLocalDate().plusDays(1);
        if(lDateJour.isBefore(lDateActivation)) {
        	actif = false;
        }
        
        return actif;
    }
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tiers [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", numCompte=" + numCompte
				+ ", idclientT=" + idclientT + ", date_creation=" + date_creation + "]";
	}   
}