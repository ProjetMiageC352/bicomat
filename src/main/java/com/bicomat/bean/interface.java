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
        // TODO implement here
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
        // TODO implement here
    }

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
