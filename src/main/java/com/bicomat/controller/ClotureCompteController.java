package com.bicomat.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bicomat.bean.Compte;
import com.bicomat.bean.Operation;
import com.bicomat.service.ICompteService;
import com.bicomat.service.IOperationService;

@Controller
@RequestMapping(value="/compteBancaire")
public class ClotureCompteController {
	
	@Autowired
	private IOperationService operationService;
	private ICompteService compteService;
	@Autowired(required=true)
	@Qualifier(value="operationService")
	public void setOperationService(IOperationService os){
		this.operationService = os;
	}
	@Autowired(required=true)
	@Qualifier(value="compteService")
	public void setCompteService(ICompteService cs){
		this.compteService = cs;
	}
	
	// Affichage la page pour la cloture du compte
				@RequestMapping(value="/cloture/{id}&{idclient}&{nom}&{prenom}&{num_contrat}", method = RequestMethod.GET)
				public String affichepagecloture(ModelMap pModel,
						@PathVariable(value="id") final int id_compte,
						
						@PathVariable(value="idclient") final int id_client,
						@PathVariable(value="nom") final String nom_client,
						@PathVariable(value="prenom") final String prenom_client,
						@PathVariable(value="num_contrat") final int num_contrat_client,
						HttpServletRequest request,
						HttpServletResponse response) throws ServletException, IOException {
					
					// Redirection si le conseiller n'est pas connecté
					HttpSession session = request.getSession();
					if (session.getAttribute("conseiller") == null) {
						request.getRequestDispatcher("connexion").forward(request, response);
					}
					
					Compte compte=compteService.getCompteAvecId(id_compte);
					double solde=compte.getSolde();
					String type_compte=compte.getType();
					
					pModel.addAttribute("id", id_compte);
					pModel.addAttribute("solde", solde);
					pModel.addAttribute("type", type_compte);
					pModel.addAttribute("id_client", id_client);
					pModel.addAttribute("nom", nom_client);
					pModel.addAttribute("prenom", prenom_client);
					pModel.addAttribute("num_contrat", num_contrat_client);
					
			        return "/compteBancaire/cloture";
				}
				
				// cloture du compte
				@RequestMapping(value="/cloture", method = RequestMethod.POST)
				public String cloturecompte(ModelMap pModel,
						@RequestParam("id_compte") int id_compte_cloturer,
						@RequestParam("montant") double montant_solde,
						@RequestParam("type") String type_compte,
						@RequestParam("id_client") int client,
						@RequestParam("nom") String nom,
						@RequestParam("prenom") String prenom,
						@RequestParam("num_contrat") int num_contrat,
						HttpServletRequest request,
						HttpServletResponse response
						) throws ServletException, IOException {
					
					// Redirection si le conseiller n'est pas connecté
					HttpSession session = request.getSession();
					if (session.getAttribute("conseiller") == null) {
						request.getRequestDispatcher("connexion").forward(request, response);
					}
					
					//retourne le compte à cloturer
					Compte compte_cloturer = new Compte();
					compte_cloturer=compteService.getCompteAvecId(id_compte_cloturer);
					
					//récuperer l'id du compte courant du client
					Compte compte_courant = new Compte();
					compte_courant=compteService.getCompteIdCompteCourant(client);
					int id_compte_courant=compte_courant.getId();
					
					
					
					// opération sur le compte à cloturer=opération du montant du solde
					Operation op=new Operation();
					op.setIdCompte(id_compte_cloturer);
					op.setMontant(0-montant_solde);
					op.setType("Virement vers compte Courant ");
					op.setDate(Date.valueOf(LocalDate.now()));
					operationService. ajouterOperation(op);
					
					//opération sur le compte destinataire lors de la cloture= compte courant par défaut
					Operation op_dest=new Operation();
					op_dest.setDate(Date.valueOf(LocalDate.now()));
					op_dest.setMontant(montant_solde);
					op_dest.setType("Clôture du compte "+type_compte);
					op_dest.setIdCompte(id_compte_courant);
					operationService. ajouterOperation(op_dest);
					
					// Mise Ã  jour du solde pour le compte à cloturer
					compte_cloturer.setSolde(compte_cloturer.getSolde()-montant_solde);
					compteService.modifierCompte(compte_cloturer);
					
					// Mise Ã  jour du solde pour le compte à destinataire = compte courant
					compte_courant.setSolde(compte_courant.getSolde()+montant_solde);
					compteService.modifierCompte(compte_courant);
					
					//cloture du compte
					compte_cloturer.setActif(false);
					compteService.modifierCompte(compte_cloturer);
			        return "compteBancaire/clotureok";
				}
}
