package com.bicomat.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client")
/** 
 * Classe client
 */

public class Client {
	
	/**
	 * Id du client
	 */
	@Id
	@Column(name="c_id_client")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	/** 
	 * Nom du client
	 */
	@Column(name="c_nom")
	private String nom;
	/**
	 * Prenom du client
	 */
	@Column(name="c_prenom")
	private String prenom;
	/**
	 * Adresse Mail du client
	 */
	@Column(name="c_adresse_mail")
	private String adresse_mail;
	/**
	 * Type du client
	 */
	@Column(name="c_type_client")
	private String type_client;
	
	
	/* **************************** */
	/*         CONSTRUCTEURS        */
	/* **************************** */
	
	/**
     * Constructeur par défaut de la classe.
     */
	public Client() {
	}
	
	/**
     * Constructeur de la classe.
     */
	
	/**
	 * @param nomT
	 * @param prenomT
	 */
	public Client(String nomC,String prenomC,String adresseC,String typeC) {
		this.nom=nomC;
		this.prenom=prenomC;
		this.adresse_mail=adresseC;
		this.type_client=typeC;
	}
	
	
	/**
     * Constructeur de la classe.
     */
	/**
	 * @param idC
	 * @param nomC
	 * @param prenomC
	 * @param adresseC
	 * @param typeC
	 */
	public Client(final int idC,final String nomC, final String prenomC,final String adresseC, final String typeC) {
		this.id=idC;
		this.nom=nomC;
		this.prenom=prenomC;
		this.adresse_mail=adresseC;
		this.type_client=typeC;
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
	 * @return the nom
	 */
	public final String getNom() {
		return nom;
	}

	/**
	 * @return the prenom
	 */
	public final String getPrenom() {
		return prenom;
	}

	/**
	 * @return the adresse_mail
	 */
	public final String getAdresse_mail() {
		return adresse_mail;
	}

	/**
	 * @return the type_client
	 */
	public final String getType_client() {
		return type_client;
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
	 * @param nom the nom to set
	 */
	public final void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public final void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @param adresse_mail the adresse_mail to set
	 */
	public final void setAdresse_mail(String adresse_mail) {
		this.adresse_mail = adresse_mail;
	}

	/**
	 * @param type_client the type_client to set
	 */
	public final void setType_client(String type_client) {
		this.type_client = type_client;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse_mail=" + adresse_mail
				+ ", type_client=" + type_client + "]";
	}

	
    
}