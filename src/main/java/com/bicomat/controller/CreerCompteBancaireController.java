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
import org.springframework.web.bind.annotation.RequestParam;

import com.bicomat.bean.Client;
import com.bicomat.bean.Compte;
import com.bicomat.bean.Operation;
import com.bicomat.service.IClientService;
import com.bicomat.service.ICompteService;

@Controller
@RequestMapping(value="/compteBancaire")
public class CreerCompteBancaireController {
	
	@Autowired
	private ICompteService compteService;
	
	@Autowired(required=true)
	@Qualifier(value="compteService")
	public void setCompteService(ICompteService cs){
		this.compteService = cs;
	}
	
	@Autowired
	private IClientService clientService;
	
	@Autowired(required=true)
	@Qualifier(value="clientService")
	public void setclientService(IClientService cs){
		this.clientService = cs;
	}
	
	@RequestMapping(value="/creercompteBancaire/{nom}&{prenom}&{num}&{idclient}",method = RequestMethod.GET)
	public String afficherFormulaire(ModelMap pModel,
			@PathVariable(value="nom") final String nom,
			@PathVariable(value="prenom") final String prenom,
			@PathVariable(value="num") final int num_contrat,
			@PathVariable(value="idclient") final int idclient,
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//Redirection si le conseiller n'est pas connectÃ©
				HttpSession session = request.getSession();
				if (session.getAttribute("conseiller") == null) {
					request.getRequestDispatcher("connexion").forward(request, response);
				}
				pModel.addAttribute("nom", nom);
				pModel.addAttribute("prenom", prenom);
				pModel.addAttribute("num_contrat", num_contrat);		
				pModel.addAttribute("idclient", idclient);
		return "compteBancaire/creercompte";
	}
	
	@RequestMapping(value="/creercompteBancaire", method = RequestMethod.POST)
	public String ajoutercompte(ModelMap pModel,
			
			@RequestParam("montant") double montant_solde,
			@RequestParam("type") String type_compte,
			@RequestParam("idclient") int client,
			@RequestParam("nom") String nom,
			@RequestParam("prenom") String prenom,
			@RequestParam("num") int num_contrat,
			@RequestParam("decouvert") boolean decouvert,
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException {
		
		// Redirection si le conseiller n'est pas connecté
		HttpSession session = request.getSession();
		if (session.getAttribute("conseiller") == null) {
			request.getRequestDispatcher("connexion").forward(request, response);
		}
	
		//creation d'un nouveau compte
		Compte c = new Compte();
		c.setIdClient(client);
		c.setSolde(montant_solde);
		c.setType(type_compte);
		c.setDecouvert(decouvert);
		c.setActif(true);
		c.setIdBanque(1);
		compteService.ajouterCompte(c);
        return "compteBancaire/creercompte";
	}
}
	
