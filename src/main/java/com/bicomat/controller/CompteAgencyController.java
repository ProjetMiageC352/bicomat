package com.bicomat.controller;

import java.io.IOException;
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
import com.bicomat.service.IClientService;

@Controller
@RequestMapping(value="/compteAgency")
public class CompteAgencyController {
	
	@Autowired
	private IClientService clientService;
	
	@Autowired(required=true)
	@Qualifier(value="clientService")
	public void setclientService(IClientService cs){
		this.clientService = cs;
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
       
        return "compteAgency/liste";
	}
	
	// Affichage du formulaire de création de compte Agency
	@RequestMapping(value="/creer", method = RequestMethod.GET)
	public String creerCompteAgency(ModelMap pModel, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// Redirection si le conseiller n'est pas connecté
		HttpSession session = request.getSession();
		if (session.getAttribute("conseiller") == null) {
			request.getRequestDispatcher("connexion").forward(request, response);
		}
		
		pModel.addAttribute("password", 1000 + (int) (Math.random() * 10000));
		
        return "compteAgency/creation";
	}
	
	// Affichage du formulaire de création de compte Agency pour un client
	@RequestMapping(value="/creer/{nom}/{prenom}/{num_contrat}", method = RequestMethod.GET)
	public String creerCompteAgencyPourClient(ModelMap pModel,
			@PathVariable(value="nom") final String nom,
			@PathVariable(value="prenom") final String prenom,
			@PathVariable(value="num_contrat") final String num_contrat,
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// Redirection si le conseiller n'est pas connecté
		HttpSession session = request.getSession();
		if (session.getAttribute("conseiller") == null) {
			request.getRequestDispatcher("connexion").forward(request, response);
		}
		
		pModel.addAttribute("nom", nom);
		pModel.addAttribute("prenom", prenom);
		pModel.addAttribute("num_contrat", num_contrat);
		pModel.addAttribute("password", 1000 + (int) (Math.random() * 10000));
		
        return "compteAgency/creation";
	}
	
	// Validation de la création du compte Agency
	@RequestMapping(value="/creer", method = RequestMethod.POST)
	public String validationCreationCompteAgency(ModelMap pModel,
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// Redirection si le conseiller n'est pas connecté
		HttpSession session = request.getSession();
		if (session.getAttribute("conseiller") == null) {
			request.getRequestDispatcher("connexion").forward(request, response);
		}
		
		// Si le client existe
		if (clientService.existeAvecNomPrenomNumContrat(request.getParameter("nom"),
				request.getParameter("prenom"),
				Integer.parseInt(request.getParameter("num_contrat")))) {
			
			Client client = clientService.getClientAvecNomPrenomNumContrat(
					request.getParameter("nom"),
					request.getParameter("prenom"),
					Integer.parseInt(request.getParameter("num_contrat")));
			
			// Si le client n'a pas de compte agency
			if (!client.aCompteAgency()) {
				client.setLogin(client.getNom() + client.getId());
				client.setPassword(request.getParameter("password"));
				clientService.modifierClient(client);
				
				final List<Client> lClients = clientService.listeClients();
		        pModel.addAttribute("clients", lClients);
		        
				return "compteAgency/liste";
			}
			else {
				pModel.addAttribute("erreur", "Création annulée. Le client possède déjà un compte Agency.");
			}
		}
		else {
			pModel.addAttribute("erreur", "Création annulée. Le client n'existe pas.");
		}
		
		return "compteAgency/creation";
	}
}
