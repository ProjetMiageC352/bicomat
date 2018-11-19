package com.bicomat.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe Banque.
 */
@Entity
@Table(name="banque")
public class Banque {

	/* **************************** */
	/*           ATTRIBUTS          */
	/* **************************** */
	
	/**
	 * Id de la banque.
	 */
	@Id
	@Column(name="b_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int b_id = 0;
	/**
	 * Nom de la banque.
	 */
	protected String b_nom = "";
	/**
	 * Adresse de la banque.
	 */
	protected String b_adresse = "";
	
	/* **************************** */
	/*         CONSTRUCTEURS        */
	/* **************************** */
	
    /**
     * Constructeur par défaut de la classe.
     */
    public Banque() {
    }
    /**
     * Constructeur de la classe.
     *
     * @param nomB Nom de la banque
     * @param adresseB Adresse de la banque
     */
    public Banque(final String nomB, final String adresseB) {
    	this.b_nom = nomB;
    	this.b_adresse = adresseB;
    }
    /**
     * Constructeur de la classe.
     *
     * @param idB Id de la banque
     * @param nomB Nom de la banque
     * @param adresseB Adresse de la banque
     */
    public Banque(final int idB, final String nomB, final String adresseB) {
        this.b_id = idB;
        this.b_nom = nomB;
    	this.b_adresse = adresseB;
    }
    
    /* **************************** */
	/*            GETTERS           */
	/* **************************** */

    /**
     * Getter de l'id.
     *
     * @return b_id
     */
    public final int getId() {
        return b_id;
    }
    /**
     * Getter du nom.
     *
     * @return b_nom
     */
    public final String getNom() {
        return b_nom;
    }
    /**
     * Getter de l'adresse.
     *
     * @return b_adresse
     */
    public final String getAdresse() {
        return b_adresse;
    }
    
    /* **************************** */
	/*            SETTERS           */
	/* **************************** */

    /**
     * Setter de l'id.
     *
     * @param idB Nouvel id
     */
    public final void setId(final int idB) {
        this.b_id = idB;
    }
    /**
     * Setter du nom.
     *
     * @param nomB Nouveau nom
     */
    public final void setNom(final String nomB) {
        this.b_nom = nomB;
    }
    /**
     * Setter de l'adresse.
     *
     * @param adresseB Nouvelle adresse
     */
    public final void setAdresse(final String adresseB) {
        this.b_adresse = adresseB;
    }
}