package com.bicomat.bean;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests unitaires pour la classe Conseiller.
 */
public class ConseillerTest {

    /**
     * Conseiller pour les tests.
     */
    private static Conseiller c;

    /**
     * Initialisation avant le premier test.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        c = new Conseiller(1, "Nom", "Prenom", "Login", "Password", 1);
    }
    
    /* **************************** */
	/*         CONSTRUCTEURS        */
	/* **************************** */

    /**
     * Test du contructeur.
     */
    @Test
    public final void testConstructeur() {
        Assert.assertNotNull(new Conseiller());
        Assert.assertNotNull(new Conseiller("Nom", "Prenom", "Login", "Password", 1));
        Assert.assertNotNull(new Conseiller(1, "Nom", "Prenom", "Login", "Password", 1));
    }
    
    /* **************************** */
	/*            GETTERS           */
	/* **************************** */

    /**
     * Test de getId().
     */
    @Test
    public final void testGetId() {
        Assert.assertEquals(c.getId(), 1);
    }
    /**
     * Test de getNom().
     */
    @Test
    public final void testGetNom() {
        Assert.assertEquals(c.getNom(), "Nom");
    }
    /**
     * Test de getPrenom().
     */
    @Test
    public final void testGetPrenom() {
        Assert.assertEquals(c.getPrenom(), "Prenom");
    }
    /**
     * Test de getLoginAgency().
     */
    @Test
    public final void testGetLoginAgency() {
        Assert.assertEquals(c.getLoginAgency(), "Login");
    }
    /**
     * Test de getPasswordAgency().
     */
    @Test
    public final void testGetPasswordAgency() {
        Assert.assertEquals(c.getPasswordAgency(), "Password");
    }
    /**
     * Test de getIdBanque().
     */
    @Test
    public final void testGetIdBanque() {
        Assert.assertEquals(c.getIdBanque(), 1);
    }
    
    /* **************************** */
	/*            SETTERS           */
	/* **************************** */

    /**
     * Test de setId(int idC).
     */
    @Test
    public final void testSetId() {
        c.setId(2);
        Assert.assertEquals(c.getId(), 2);
        c.setId(1);
        Assert.assertEquals(c.getId(), 1);
    }
    /**
     * Test de setNom(String nomC).
     */
    @Test
    public final void testSetNom() {
        c.setNom("Nom2");
        Assert.assertEquals(c.getNom(), "Nom2");
        c.setNom("Nom");
        Assert.assertEquals(c.getNom(), "Nom");
    }
    /**
     * Test de setPrenom(String prenomC).
     */
    @Test
    public final void testSetPrenom() {
        c.setPrenom("Prenom2");
        Assert.assertEquals(c.getPrenom(), "Prenom2");
        c.setPrenom("Prenom");
        Assert.assertEquals(c.getPrenom(), "Prenom");
    }
    /**
     * Test de setLoginAgency(String loginAgencyC).
     */
    @Test
    public final void testSetLoginAgency() {
        c.setLoginAgency("Login2");
        Assert.assertEquals(c.getLoginAgency(), "Login2");
        c.setLoginAgency("Login");
        Assert.assertEquals(c.getLoginAgency(), "Login");
    }
    /**
     * Test de setPasswordAgency(String passwordAgencyC).
     */
    @Test
    public final void testSetPasswordAgency() {
        c.setPasswordAgency("Password2");
        Assert.assertEquals(c.getPasswordAgency(), "Password2");
        c.setPasswordAgency("Password");
        Assert.assertEquals(c.getPasswordAgency(), "Password");
    }
    /**
     * Test de setIdBanque(int idBanqueC).
     */
    @Test
    public final void testSetIdBanque() {
        c.setIdBanque(2);
        Assert.assertEquals(c.getIdBanque(), 2);
        c.setIdBanque(1);
        Assert.assertEquals(c.getIdBanque(), 1);
    }
    
    /* **************************** */
	/*           METHODES           */
	/* **************************** */
    
    /**
     * Test de toString().
     */
    @Test
    public final void testToString() {
        Assert.assertEquals(c.toString(), "Conseiller [id = 1, nom = Nom, prenom = Prenom, "
        		+ "login agnecy = Login, password agnecy = Password, id banque = 1]");
    }
}
