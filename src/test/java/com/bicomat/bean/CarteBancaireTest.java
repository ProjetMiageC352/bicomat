package com.bicomat.bean;

import java.sql.Date;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests unitaires pour la classe CarteBancaire.
 */
public class CarteBancaireTest {

    /**
     * CarteBancaire pour les tests.
     */
    private static CarteBancaire cb;

    /**
     * Initialisation avant le premier test.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        cb = new CarteBancaire(1, "0001", "Type", Date.valueOf("2018-01-01"), 1);
    }
    
    /* **************************** */
	/*         CONSTRUCTEURS        */
	/* **************************** */

    /**
     * Test du contructeur.
     */
    @Test
    public final void testConstructeur() {
        Assert.assertNotNull(new CarteBancaire());
        Assert.assertNotNull(new CarteBancaire("0001", "Type", Date.valueOf("2018-01-01"), 1));
        Assert.assertNotNull(new CarteBancaire(1, "0001", "Type", Date.valueOf("2018-01-01"), 1));
    }
    
    /* **************************** */
	/*            GETTERS           */
	/* **************************** */

    /**
     * Test de getId().
     */
    @Test
    public final void testGetId() {
        Assert.assertEquals(cb.getIdC(), 1);
    }
    /**
     * Test de getNum_carte().
     */
    @Test
    public final void testGetNum_carte() {
        Assert.assertEquals(cb.getNum_carte(), "0001");
    }
    /**
     * Test de getType_carte().
     */
    @Test
    public final void testGetType_carte() {
        Assert.assertEquals(cb.getType_carte(), "Type");
    }
    /**
     * Test de getCb_idclient().
     */
    @Test
    public final void testGetCb_idclient() {
        Assert.assertEquals(cb.getCb_idclient(), 1);
    }
    
    /* **************************** */
	/*            SETTERS           */
	/* **************************** */

    /**
     * Test de setIdC(int idC).
     */
    @Test
    public final void testSetIdC() {
        cb.setIdC(2);
        Assert.assertEquals(cb.getIdC(), 2);
        cb.setIdC(1);
        Assert.assertEquals(cb.getIdC(), 1);
    }
    /**
     * Test de setNum_carte(String num_carte).
     */
    @Test
    public final void testSetNum_carte() {
        cb.setNum_carte("0002");
        Assert.assertEquals(cb.getNum_carte(), "0002");
        cb.setNum_carte("0001");
        Assert.assertEquals(cb.getNum_carte(), "0001");
    }
    /**
     * Test de setType_carte(String type_carte).
     */
    @Test
    public final void testSetType_carte() {
        cb.setType_carte("Type2");
        Assert.assertEquals(cb.getType_carte(), "Type2");
        cb.setType_carte("Type");
        Assert.assertEquals(cb.getType_carte(), "Type");
    }
    /**
     * Test de setEcheance(int echeance).
     */
    @Test
    public final void testSetEcheance() {
        cb.setEcheance(Date.valueOf("2017-01-01"));
        Assert.assertEquals(cb.getEcheance(), Date.valueOf("2017-01-01"));
        cb.setEcheance(Date.valueOf("2018-01-01"));
        Assert.assertEquals(cb.getEcheance(), Date.valueOf("2018-01-01"));
    }
    /**
     * Test de setCb_idclient(int cb_idclient).
     */
    @Test
    public final void testSetCb_idclient() {
        cb.setCb_idclient(2);
        Assert.assertEquals(cb.getCb_idclient(), 2);
        cb.setCb_idclient(1);
        Assert.assertEquals(cb.getCb_idclient(), 1);
    }
    
    /* **************************** */
	/*           METHODES           */
	/* **************************** */
    
    /**
     * Test de toString().
     */
    @Test
    public final void testToString() {
    	Assert.assertEquals(cb.toString(), "CarteBancaire [idC=1, num_carte=0001, "
        		+ "type_carte=Type, echeance=2018-01-01, cb_idclient=1]");
    }
}
