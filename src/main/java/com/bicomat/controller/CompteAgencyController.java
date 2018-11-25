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
		
        return "compteAgency/creation";
	}
	
	// Affichage du formulaire de création de compte Agency pour un client
	@RequestMapping(value="/creer/{nom}/{prenom}/{num}", method = RequestMethod.GET)
	public String creerCompteAgencyPourClient(ModelMap pModel,
			@PathVariable(value="nom") final String nom,
			@PathVariable(value="prenom") final String prenom,
			@PathVariable(value="num") final String num,
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// Redirection si le conseiller n'est pas connecté
		HttpSession session = request.getSession();
		if (session.getAttribute("conseiller") == null) {
			request.getRequestDispatcher("connexion").forward(request, response);
		}
		
		pModel.addAttribute("nom", nom);
		pModel.addAttribute("prenom", prenom);
		pModel.addAttribute("num", num);
		
        return "compteAgency/creation";
	}
}
