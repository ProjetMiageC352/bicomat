package com.bicomat.bean;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests unitaires pour la classe Compte.
 */
public class CompteTest {

    /**
     * Compte pour les tests.
     */
    private static Compte c;

    /**
     * Initialisation avant le premier test.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        c = new Compte(1, "Type", true, 100, true, 1, 1);
    }
    
    /* **************************** */
	/*         CONSTRUCTEURS        */
	/* **************************** */

    /**
     * Test du contructeur.
     */
    @Test
    public final void testConstructeur() {
        Assert.assertNotNull(new Compte());
        Assert.assertNotNull(new Compte("Type", true, 100, true, 1, 1));
        Assert.assertNotNull(new Compte(1, "Type", true, 100, true, 1, 1));
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
     * Test de getType().
     */
    @Test
    public final void testGetType() {
        Assert.assertEquals(c.getType(), "Type");
    }
    /**
     * Test de getDecouvert().
     */
    @Test
    public final void testGetDecouvert() {
        Assert.assertTrue(c.getDecouvert());
    }
    /**
     * Test de getSolde().
     */
    @Test
    public final void testGetSolde() {
        Assert.assertEquals(c.getSolde(), 100, 0);
    }
    /**
     * Test de getActif().
     */
    @Test
    public final void testGetActif() {
        Assert.assertTrue(c.getActif());
    }
    /**
     * Test de getIdBanque().
     */
    @Test
    public final void testGetIdBanque() {
        Assert.assertEquals(c.getIdBanque(), 1);
    }
    /**
     * Test de getIdClient().
     */
    @Test
    public final void testGetIdClient() {
        Assert.assertEquals(c.getIdClient(), 1);
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
     * Test de setType(String typeC).
     */
    @Test
    public final void testSetType() {
        c.setType("Type2");
        Assert.assertEquals(c.getType(), "Type2");
        c.setType("Type");
        Assert.assertEquals(c.getType(), "Type");
    }
    /**
     * Test de setDecouvert(boolean decouvertC).
     */
    @Test
    public final void testSetDecouvert() {
        c.setDecouvert(false);
        Assert.assertFalse(c.getDecouvert());
        c.setDecouvert(true);
        Assert.assertTrue(c.getDecouvert());
    }
    /**
     * Test de setSolde(double soldeC).
     */
    @Test
    public final void testSetSolde() {
        c.setSolde(200);
        Assert.assertEquals(c.getSolde(), 200, 0);
        c.setSolde(100);
        Assert.assertEquals(c.getSolde(), 100, 0);
    }
    /**
     * Test de setActif( boolean actifC).
     */
    @Test
    public final void testSetActif() {
        c.setActif(false);
        Assert.assertFalse(c.getActif());
        c.setActif(true);
        Assert.assertTrue(c.getActif());
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
    /**
     * Test de setIdClient(int idClientC).
     */
    @Test
    public final void testSetIdClient() {
        c.setIdClient(2);
        Assert.assertEquals(c.getIdClient(), 2);
        c.setIdClient(1);
        Assert.assertEquals(c.getIdClient(), 1);
    }
    
    /* **************************** */
	/*           METHODES           */
	/* **************************** */
    
    /**
     * Test de toString().
     */
    @Test
    public final void testToString() {
    	Assert.assertEquals(c.toString(), "Compte [id = 1, type = Type, découvert = true, "
        		+ "solde = 100.0, id banque = 1, id client = 1]");
    }
}
