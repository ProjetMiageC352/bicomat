package com.bicomat.bean;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests unitaires pour la classe Banque.
 */
public class BanqueTest {

    /**
     * Banque pour les tests.
     */
    private static Banque b;

    /**
     * Initialisation avant le premier test.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        b = new Banque(1, "Nom", "Adresse");
    }
    
    /* **************************** */
	/*         CONSTRUCTEURS        */
	/* **************************** */

    /**
     * Test du contructeur.
     */
    @Test
    public final void testConstructeur() {
        Assert.assertNotNull(new Banque());
        Assert.assertNotNull(new Banque("Nom", "Adresse"));
        Assert.assertNotNull(new Banque(1, "Nom", "Adresse"));
    }
    
    /* **************************** */
	/*            GETTERS           */
	/* **************************** */

    /**
     * Test de getId().
     */
    @Test
    public final void testGetId() {
        Assert.assertEquals(b.getId(), 1);
    }
    /**
     * Test de getNom().
     */
    @Test
    public final void testGetNom() {
        Assert.assertEquals(b.getNom(), "Nom");
    }
    /**
     * Test de getAdresse().
     */
    @Test
    public final void testGetAdresse() {
        Assert.assertEquals(b.getAdresse(), "Adresse");
    }
    
    /* **************************** */
	/*            SETTERS           */
	/* **************************** */

    /**
     * Test de setId(int idB).
     */
    @Test
    public final void testSetId() {
        b.setId(2);
        Assert.assertEquals(b.getId(), 2);
        b.setId(1);
        Assert.assertEquals(b.getId(), 1);
    }
    /**
     * Test de setNom(String nomB).
     */
    @Test
    public final void testSetNom() {
        b.setNom("Nom2");
        Assert.assertEquals(b.getNom(), "Nom2");
        b.setNom("Nom");
        Assert.assertEquals(b.getNom(), "Nom");
    }
    /**
     * Test de setAdresse(String adresseB).
     */
    @Test
    public final void testSetAdresse() {
        b.setAdresse("Adresse2");
        Assert.assertEquals(b.getAdresse(), "Adresse2");
        b.setAdresse("Adresse");
        Assert.assertEquals(b.getAdresse(), "Adresse");
    }
    
    /* **************************** */
	/*           METHODES           */
	/* **************************** */
    
    /**
     * Test de toString().
     */
    @Test
    public final void testToString() {
        Assert.assertEquals(b.toString(), "Banque [id = 1, nom = Nom, adresse = Adresse]");
    }
}
