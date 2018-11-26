package com.bicomat.bean;

import java.sql.Date;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests unitaires pour la classe Tiers.
 */
public class TiersTest {

    /**
     * Tiers pour les tests.
     */
    private static Tiers t;

    /**
     * Initialisation avant le premier test.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        t = new Tiers(1, "Nom", "Prenom", "0001", 1, Date.valueOf("2018-01-01"));
    }
    
    /* **************************** */
	/*         CONSTRUCTEURS        */
	/* **************************** */

    /**
     * Test du contructeur.
     */
    @Test
    public final void testConstructeur() {
        Assert.assertNotNull(new Tiers());
        Assert.assertNotNull(new Tiers("Nom", "Prenom", "0001", 1, Date.valueOf("2018-01-01")));
        Assert.assertNotNull(new Tiers(1, "Nom", "Prenom", "0001", 1, Date.valueOf("2018-01-01")));
    }
    
    /* **************************** */
	/*            GETTERS           */
	/* **************************** */

    /**
     * Test de getId().
     */
    @Test
    public final void testGetId() {
        Assert.assertEquals(t.getId(), 1);
    }
    /**
     * Test de getNom().
     */
    @Test
    public final void testGetNom() {
        Assert.assertEquals(t.getNom(), "Nom");
    }
    /**
     * Test de getPrenom().
     */
    @Test
    public final void testGetPrenom() {
        Assert.assertEquals(t.getPrenom(), "Prenom");
    }
    /**
     * Test de getNumCompte().
     */
    @Test
    public final void testGetNumCompte() {
        Assert.assertEquals(t.getNumCompte(), "0001");
    }
    /**
     * Test de getIdclientT().
     */
    @Test
    public final void testGetIdclientT() {
        Assert.assertEquals(t.getIdclientT(), 1);
    }
    /**
     * Test de getDate_creation().
     */
    @Test
    public final void testGetDate_creation() {
        Assert.assertEquals(t.getDate_creation(), Date.valueOf("2018-01-01"));
    }
    
    /* **************************** */
	/*            SETTERS           */
	/* **************************** */

    /**
     * Test de setId(int idT).
     */
    @Test
    public final void testSetId() {
        t.setId(2);
        Assert.assertEquals(t.getId(), 2);
        t.setId(1);
        Assert.assertEquals(t.getId(), 1);
    }
    /**
     * Test de setNom(String nomT).
     */
    @Test
    public final void testSetNom() {
        t.setNom("Nom2");
        Assert.assertEquals(t.getNom(), "Nom2");
        t.setNom("Nom");
        Assert.assertEquals(t.getNom(), "Nom");
    }
    /**
     * Test de setPrenom(String prenomT).
     */
    @Test
    public final void testSetPrenom() {
        t.setPrenom("Prenom2");
        Assert.assertEquals(t.getPrenom(), "Prenom2");
        t.setPrenom("Prenom");
        Assert.assertEquals(t.getPrenom(), "Prenom");
    }
    /**
     * Test de setNumCompte(String numCompteT).
     */
    @Test
    public final void testSetNumCompte() {
        t.setNumCompte("0002");
        Assert.assertEquals(t.getNumCompte(), "0002");
        t.setNumCompte("0001");
        Assert.assertEquals(t.getNumCompte(), "0001");
    }
    /**
     * Test de setIdclientT(int idclientT).
     */
    @Test
    public final void testSetIdclientT() {
        t.setIdclientT(2);
        Assert.assertEquals(t.getIdclientT(), 2);
        t.setIdclientT(1);
        Assert.assertEquals(t.getIdclientT(), 1);
    }
    /**
     * Test de setDate_creation(Date date_creation).
     */
    @Test
    public final void testSetDate_creation() {
        t.setDate_creation(Date.valueOf("2017-01-01"));
        Assert.assertEquals(t.getDate_creation(), Date.valueOf("2017-01-01"));
        t.setDate_creation(Date.valueOf("2018-01-01"));
        Assert.assertEquals(t.getDate_creation(), Date.valueOf("2018-01-01"));
    }
    
    /* **************************** */
	/*           METHODES           */
	/* **************************** */
    
    /**
     * Test de isActif().
     */
    @Test
    public final void testIsActif() {
        t.setDate_creation(Date.valueOf("3018-01-01"));
        Assert.assertFalse(t.isActif());
        t.setDate_creation(Date.valueOf("2018-01-01"));
        Assert.assertTrue(t.isActif());
    }
    /**
     * Test de toString().
     */
    @Test
    public final void testToString() {
    	Assert.assertEquals(t.toString(), "Tiers [id=1, nom=Nom, prenom=Prenom, "
    			+ "numCompte=0001, idclientT=1, date_creation=2018-01-01]");
    }
}
