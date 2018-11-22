import java.util.*;

/**
 * 
 */
public class Interface {

    /**
     * Default constructor
     */
    public Interface() {
    }

    /**
     * 
     */
    public void Attendre24h() { //le client devra attendre 24h pour l'activation de son compte
        // TODO implement here
    }

    /**
     * 
     */
    public void FournirRenseignement() { //saisie du nom, prénom...
        
        Scanner sc = new Scanner(System.in); //récupération des différents paramètres saisis 
        System.out.println("Veuillez saisir votre nom :");
        String nom = sc.nextLine();
        System.out.println("Veuillez saisir votre prénom :");
        String type = sc.nextLine();    
    }

    /**
     * 
     */
    public void DemanderRelevéOpération() {
        // TODO implement here
    }

    /**
     * 
     */
    public void AfficherListe() {
        // TODO implement here
    }

    /**
     * 
     */
    public void CréerCompte() {
        Scanner sc = new Scanner(System.in); //récupération des différents paramètres saisis 
        System.out.println("Veuillez saisir un id :");
        int id = sc.nextInt();
        System.out.println("Veuillez saisir un type :");
        String type = sc.nextLine();
        
        System.out.println("Veuillez saisir l'identifiant de la banque :");
        int idBanque = sc.nextInt();
        
        System.out.println("Veuillez saisir l'identifiant Client :");
        int idClient = sc.nextInt();
        
        Compte compte = new Compte(id, type, idBanque, idClient); // instanciation de l'objet créé 
        
        
    /**
     * 
     */
    public void CréerCompteAgency() {
        // TODO implement here
    }

    /**
     * 
     */
    public void ClôturerCompte() {
        // TODO implement here
    }

    /**
     * 
     */
    public double CalculerIntérêts(double emprunt, float taux_interet) {
     double Intérêts = emprunt * taux_interet;
     return Intérêts;
    }
    /**
     * 
     */
   public double CalculerImpôts(double Revenus, float taux_marginal) {
        return Revenus*taux_marginal;
        // TODO implement here
    }

    /**
     * 
     */
    public void Créer_virement() {
        // TODO implement here
    }

}
