package com.bicomat.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

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

import com.bicomat.bean.Client;
import com.bicomat.bean.Compte;
import com.bicomat.bean.Operation;
import com.bicomat.bean.Tiers;
import com.bicomat.service.IClientService;
import com.bicomat.service.ICompteService;
import com.bicomat.service.IOperationService;
import com.bicomat.service.ITiersService;

@Controller
@RequestMapping(value="/virement")
public class VirementController {
	
	@Autowired
	private IClientService clientService;
	
	@Autowired(required=true)
	@Qualifier(value="clientService")
	public void setclientService(IClientService cs){
		this.clientService = cs;
	}
	
	@Autowired
	private ICompteService compteService;
	
	@Autowired(required=true)
	@Qualifier(value="compteService")
	public void setCompteService(ICompteService cs){
		this.compteService = cs;
	}
	
	@Autowired
	private ITiersService tiersService;
	
	@Autowired(required=true)
	@Qualifier(value="tiersService")
	public void setTiersService(ITiersService ts){
		this.tiersService = ts;
	}
	
	@Autowired
	private IOperationService operationService;
	
	@Autowired(required=true)
	@Qualifier(value="operationService")
	public void setOperationService(IOperationService os){
		this.operationService = os;
	}
	
	
	// Affichage de la liste des clients
	@RequestMapping(method = RequestMethod.GET)
	public String listeClients(ModelMap pModel, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// Redirection si le conseiller n'est pas connecté
		HttpSession session = request.getSession();
		if (session.getAttribute("conseiller") == null) {
			request.getRequestDispatcher("connexion").forward(request, response);
		}
		
		final List<Client> lClients = clientService.listeClients();
        pModel.addAttribute("clients", lClients);
       
        return "virement/liste";
	}
	
	// Affichage du formulaire de virement pour un client
	@RequestMapping(value="/creer/{id}", method = RequestMethod.GET)
	public String creerVirementPourClient(ModelMap pModel,
			@PathVariable(value="id") final String id,
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// Redirection si le conseiller n'est pas connecté
		HttpSession session = request.getSession();
		if (session.getAttribute("conseiller") == null) {
			request.getRequestDispatcher("connexion").forward(request, response);
		}
		
		final List<Compte> lComptes = compteService.listeComptesparclient(Integer.parseInt(id));
        pModel.addAttribute("comptes", lComptes);
        
        final List<Tiers> lTiers = tiersService.listeTiersActifsPourClient(Integer.parseInt(id));
        pModel.addAttribute("tiers", lTiers);
		
        return "virement/virement";
	}
	
	// Validation du virement
	@RequestMapping(value="/creer/{id}", method = RequestMethod.POST)
	public String validationVirement(ModelMap pModel,
			@PathVariable(value="id") final String id,
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// Redirection si le conseiller n'est pas connecté
		HttpSession session = request.getSession();
		if (session.getAttribute("conseiller") == null) {
			request.getRequestDispatcher("connexion").forward(request, response);
		}
		
		// Virement interne
		if (request.getParameter("virementInterne") != null) {
			Compte compteSource = compteService.getCompteAvecId(Integer.parseInt(request.getParameter("cpteSource")));
			Compte compteDestinataire = compteService.getCompteAvecId(Integer.parseInt(request.getParameter("cpteDestination")));
			int montant = Integer.parseInt(request.getParameter("montant"));
			
			// Si compte source = compte destinataire
			if (compteSource.getId() == compteDestinataire.getId()) {
				pModel.addAttribute("erreur", "Virement non effectué. Le compte source et le compte destinataire sont identiques.");
			}
			else {
				// Si solde insuffisant
				if (compteSource.getSolde() < montant) {
					pModel.addAttribute("erreur", "Virement non effectué. Le solde est insuffisant.");
				}
				else {
					// Enregistrement de l'opération pour le compte source
					Operation os = new Operation();
					os.setDate(Date.valueOf(LocalDate.now()));
					os.setMontant(0-montant);
					os.setType("Virement vers " + compteDestinataire.getType() + " (" + compteDestinataire.getId() + ")");
					os.setIdCompte(compteSource.getId());
					operationService.ajouterOperation(os);
					
					// Mise à jour du solde pour le compte source
					compteSource.setSolde(compteSource.getSolde()-montant);
					compteService.modifierCompte(compteSource);
					
					// Enregistrement de l'opération pour le compte destinataire
					Operation od = new Operation();
					od.setDate(Date.valueOf(LocalDate.now()));
					od.setMontant(montant);
					od.setType("Virement depuis " + compteSource.getType() + " (" + compteSource.getId() + ")");
					od.setIdCompte(compteDestinataire.getId());
					operationService.ajouterOperation(od);
					
					// Mise à jour du solde pour le compte destinataire
					compteDestinataire.setSolde(compteDestinataire.getSolde()+montant);
					compteService.modifierCompte(compteDestinataire);
				}
			}
		}
		
		// Virement tiers
		if (request.getParameter("virementTiers") != null) {
			Compte compteSourceT = compteService.getCompteAvecId(Integer.parseInt(request.getParameter("cpteSourceTiers")));
			int montantT = Integer.parseInt(request.getParameter("montantTiers"));
			
			// Si compte tiers non vide
			if (request.getParameter("cpteDestinationTiers") != null) {
				// Si solde insuffisant
				if (compteSourceT.getSolde() < montantT) {
					pModel.addAttribute("erreur", "Virement non effectué. Le solde est insuffisant.");
				}
				else {
					// Enregistrement de l'opération
					Operation o = new Operation();
					o.setDate(Date.valueOf(LocalDate.now()));
					o.setMontant(0-montantT);
					o.setType("Virement vers un tiers (" + request.getParameter("cpteDestinationTiers") + ")");
					o.setIdCompte(compteSourceT.getId());
					
					operationService.ajouterOperation(o);
					
					// Mise à jour du solde
					compteSourceT.setSolde(compteSourceT.getSolde()-montantT);
					compteService.modifierCompte(compteSourceT);
				}
			}
			else {
				pModel.addAttribute("erreur", "Virement non effectué. Vous n'avez pas de compte tiers.");
			}
		}
		
		pModel.addAttribute("id", id);
		final List<Compte> lComptes = compteService.listeComptesparclient(Integer.parseInt(id));
        pModel.addAttribute("comptes", lComptes);
        final List<Tiers> lTiers = tiersService.listeTiersActifsPourClient(Integer.parseInt(id));
        pModel.addAttribute("tiers", lTiers);
		
		return "virement/virement";
	}
}
