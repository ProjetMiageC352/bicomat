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
	@Column(name="c_id")
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
	 * Telephone du client
	 */
	@Column(name="c_num_tel")
	private int tel_client;
	/**
	 * Numero de contrat du client
	 */
	@Column(name="c_num_contrat")
	private int num_contrat;
	 /**
	  *  Id du conseiller du client
	 */
	@Column(name="c_id_conseiller")
	private int id_conseiller;
	 /**
	  * login du client
	 */
	@Column(name="c_login")
	private String login;
	/**
	  * Mot de passe du client
	 */
	@Column(name="c_mdp")
	private String password;
	
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
     * 
	 * @param nomC
	 * @param prenomC
	 * @param adresseC
	 * @param telC
	 * @param contratC
	 * @param conseillerC
	 * @param loginC
	 * @param passwordC
	 */
	public Client(String nomC,String prenomC,String adresseC,int telC,int contratC,int conseillerC, String loginC,String passwordC) {
		this.nom=nomC;
		this.prenom=prenomC;
		this.adresse_mail=adresseC;
		this.tel_client=telC;
		this.num_contrat=contratC;
		this.id_conseiller=conseillerC;
		this.login=loginC;
		this.password=passwordC;
	}
	/**
     * Constructeur de la classe.
     * 
	 * @param idC
	 * @param nomC
	 * @param prenomC
	 * @param adresseC
	 * @param telC
	 * @param contratC
	 * @param conseillerC
	 * @param loginC
	 * @param passwordC
	 */
	public Client(int idC, String nomC, String prenomC, String adresseC, int telC,
			int contratC, int conseillerC, String loginC, String passwordC) {
		this.id = idC;
		this.nom=nomC;
		this.prenom=prenomC;
		this.adresse_mail=adresseC;
		this.tel_client=telC;
		this.num_contrat=contratC;
		this.id_conseiller=conseillerC;
		this.login=loginC;
		this.password=passwordC;
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
	 * @return the tel_client
	 */
	public final int getTel_client() {
		return tel_client;
	}

	/**
	 * @return the num_contrat
	 */
	public final int getNum_contrat() {
		return num_contrat;
	}

	/**
	 * @return the id_conseiller
	 */
	public final int getId_conseiller() {
		return id_conseiller;
	}

	/**
	 * @return the login
	 */
	public final String getLogin() {
		return login;
	}

	/**
	 * @return the password
	 */
	public final String getPassword() {
		return password;
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
	 * @param tel_client the tel_client to set
	 */
	public final void setTel_client(int tel_client) {
		this.tel_client = tel_client;
	}

	/**
	 * @param num_contrat the num_contrat to set
	 */
	public final void setNum_contrat(int num_contrat) {
		this.num_contrat = num_contrat;
	}

	/**
	 * @param id_conseiller the id_conseiller to set
	 */
	public final void setId_conseiller(int id_conseiller) {
		this.id_conseiller = id_conseiller;
	}

	/**
	 * @param login the login to set
	 */
	public final void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @param password the password to set
	 */
	public final void setPassword(String password) {
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse_mail=" + adresse_mail
				+ ", tel_client=" + tel_client + ", num_contrat=" + num_contrat + ", id_conseiller=" + id_conseiller
				+ ", login=" + login + ", password=" + password + "]";
	}
  
}