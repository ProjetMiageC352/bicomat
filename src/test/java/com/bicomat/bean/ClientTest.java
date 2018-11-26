package com.bicomat.bean;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests unitaires pour la classe Client.
 */
public class ClientTest {

    /**
     * Client pour les tests.
     */
    private static Client c;

    /**
     * Initialisation avant le premier test.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        c = new Client(1, "Nom", "Prenom", "Adresse", "0606060606", 1, 1, "Login", "Password");
    }
    
    /* **************************** */
	/*         CONSTRUCTEURS        */
	/* **************************** */

    /**
     * Test du contructeur.
     */
    @Test
    public final void testConstructeur() {
        Assert.assertNotNull(new Client());
        Assert.assertNotNull(new Client("Nom", "Prenom", "Adresse", "0606060606", 1, 1, "Login", "Password"));
        Assert.assertNotNull(new Client(1, "Nom", "Prenom", "Adresse", "0606060606", 1, 1, "Login", "Password"));
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
     * Test de getAdresse_mail().
     */
    @Test
    public final void testGetAdresse_mail() {
        Assert.assertEquals(c.getAdresse_mail(), "Adresse");
    }
    /**
     * Test de getTel_client().
     */
    @Test
    public final void testGetTel_client() {
        Assert.assertEquals(c.getTel_client(), "0606060606");
    }
    /**
     * Test de getNum_contrat().
     */
    @Test
    public final void testGetNum_contrat() {
        Assert.assertEquals(c.getNum_contrat(), 1);
    }
    /**
     * Test de getId_conseiller().
     */
    @Test
    public final void testGetId_conseiller() {
        Assert.assertEquals(c.getId_conseiller(), 1);
    }
    /**
     * Test de getLogin().
     */
    @Test
    public final void testGetLogin() {
        Assert.assertEquals(c.getLogin(), "Login");
    }
    /**
     * Test de getPassword().
     */
    @Test
    public final void testGetPassword() {
        Assert.assertEquals(c.getPassword(), "Password");
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
     * Test de setAdresse_mail(String adresse_mailC).
     */
    @Test
    public final void testSetAdresse_mail() {
        c.setAdresse_mail("Adresse2");
        Assert.assertEquals(c.getAdresse_mail(), "Adresse2");
        c.setAdresse_mail("Adresse");
        Assert.assertEquals(c.getAdresse_mail(), "Adresse");
    }
    /**
     * Test de setTel_client(String tel_clientC).
     */
    @Test
    public final void testSetTel_client() {
        c.setTel_client("0101010101");
        Assert.assertEquals(c.getTel_client(), "0101010101");
        c.setTel_client("0606060606");
        Assert.assertEquals(c.getTel_client(), "0606060606");
    }
    /**
     * Test de setNum_contrat(int num_contratC).
     */
    @Test
    public final void testSetNum_contrat() {
        c.setNum_contrat(2);
        Assert.assertEquals(c.getNum_contrat(), 2);
        c.setNum_contrat(1);
        Assert.assertEquals(c.getNum_contrat(), 1);
    }
    /**
     * Test de setId_conseiller(int id_conseillerC).
     */
    @Test
    public final void testSetId_conseiller() {
        c.setId_conseiller(2);
        Assert.assertEquals(c.getId_conseiller(), 2);
        c.setId_conseiller(1);
        Assert.assertEquals(c.getId_conseiller(), 1);
    }
    /**
     * Test de setLogin(String loginC).
     */
    @Test
    public final void testSetLogin() {
        c.setLogin("Login2");
        Assert.assertEquals(c.getLogin(), "Login2");
        c.setLogin("Login");
        Assert.assertEquals(c.getLogin(), "Login");
    }
    /**
     * Test de setPassword(String passwordC).
     */
    @Test
    public final void testPassword() {
        c.setPassword("Password2");
        Assert.assertEquals(c.getPassword(), "Password2");
        c.setPassword("Password");
        Assert.assertEquals(c.getPassword(), "Password");
    }
    
    /* **************************** */
	/*           METHODES           */
	/* **************************** */
    
    /**
     * Test de aCompteAgency().
     */
    @Test
    public final void testACompteAgency() {
        c.setLogin("");
        Assert.assertFalse(c.aCompteAgency());
        c.setLogin("Login");
        Assert.assertTrue(c.aCompteAgency());
    }
    
    /**
     * Test de toString().
     */
    @Test
    public final void testToString() {
    	Assert.assertEquals(c.toString(), "Client [id=1, nom=Nom, prenom=Prenom, "
    			+ "adresse_mail=Adresse, tel_client=0606060606, num_contrat=1, "
    			+ "id_conseiller=1, login=Login, password=Password]");
    }
}
