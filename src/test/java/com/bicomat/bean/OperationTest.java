package com.bicomat.bean;

import java.sql.Date;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests unitaires pour la classe Operation.
 */
public class OperationTest {

    /**
     * Operation pour les tests.
     */
    private static Operation o;

    /**
     * Initialisation avant le premier test.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        o = new Operation(1, Date.valueOf("2018-01-01"), 100, "Type", 1);
    }
    
    /* **************************** */
	/*         CONSTRUCTEURS        */
	/* **************************** */

    /**
     * Test du contructeur.
     */
    @Test
    public final void testConstructeur() {
        Assert.assertNotNull(new Operation());
        Assert.assertNotNull(new Operation(Date.valueOf("2018-01-01"), 100, "Type", 1));
        Assert.assertNotNull(new Operation(1, Date.valueOf("2018-01-01"), 100, "Type", 1));
    }
    
    /* **************************** */
	/*            GETTERS           */
	/* **************************** */

    /**
     * Test de getId().
     */
    @Test
    public final void testGetId() {
        Assert.assertEquals(o.getId(), 1);
    }
    /**
     * Test de getDate().
     */
    @Test
    public final void testGetDate() {
        Assert.assertEquals(o.getDate(), Date.valueOf("2018-01-01"));
    }
    /**
     * Test de getMontant().
     */
    @Test
    public final void testGetMontant() {
        Assert.assertEquals(o.getMontant(), 100, 0);
    }
    /**
     * Test de getType().
     */
    @Test
    public final void testGetType() {
        Assert.assertEquals(o.getType(), "Type");
    }
    /**
     * Test de getIdOperation().
     */
    /*@Test
    public final void testGetIdOperation() {
        Assert.assertEquals(o.getIdOperation(), 1);
    }*/
    /**
     * Test de getIdCompte().
     */
    @Test
    public final void testGetIdCompte() {
        Assert.assertEquals(o.getIdCompte(), 1);
    }
    
    /* **************************** */
	/*            SETTERS           */
	/* **************************** */

    /**
     * Test de setId(int idO).
     */
    @Test
    public final void testSetId() {
        o.setId(2);
        Assert.assertEquals(o.getId(), 2);
        o.setId(1);
        Assert.assertEquals(o.getId(), 1);
    }
    /**
     * Test de setDate(Date dateO).
     */
    @Test
    public final void testSetDate() {
        o.setDate(Date.valueOf("2017-01-01"));
        Assert.assertEquals(o.getDate(), Date.valueOf("2017-01-01"));
        o.setDate(Date.valueOf("2018-01-01"));
        Assert.assertEquals(o.getDate(), Date.valueOf("2018-01-01"));
    }
    /**
     * Test de setMontant(double montantO).
     */
    @Test
    public final void testSetMontantt() {
        o.setMontant(200);
        Assert.assertEquals(o.getMontant(), 200, 0);
        o.setMontant(100);
        Assert.assertEquals(o.getMontant(), 100, 0);
    }
    /**
     * Test de setType(String typeO).
     */
    @Test
    public final void testSetType() {
        o.setType("Type2");
        Assert.assertEquals(o.getType(), "Type2");
        o.setType("Type");
        Assert.assertEquals(o.getType(), "Type");
    }
    /**
     * Test de setIdOperation(int idOperationO).
     */
    /*@Test
    public final void testSetIdOperation() {
        o.setIdOperation(2);
        Assert.assertEquals(o.getIdOperation(), 2);
        o.setIdOperation(1);
        Assert.assertEquals(o.getIdOperation(), 1);
    }*/
    /**
     * Test de setIdCompte(int idCompteO).
     */
    @Test
    public final void testSetIdCompte() {
        o.setIdCompte(2);
        Assert.assertEquals(o.getIdCompte(), 2);
        o.setIdCompte(1);
        Assert.assertEquals(o.getIdCompte(), 1);
    }
    
    /* **************************** */
	/*           METHODES           */
	/* **************************** */
    
    /**
     * Test de toString().
     */
    @Test
    public final void testToString() {
        Assert.assertEquals(o.toString(), "Operation [id = 1, date = 2018-01-01, "
        		+ "montant = 100.0, type = Type, id compte = 1]");
    }
}
