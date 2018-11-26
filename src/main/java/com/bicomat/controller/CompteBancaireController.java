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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bicomat.bean.Client;
import com.bicomat.bean.Compte;
import com.bicomat.service.IClientService;
import com.bicomat.service.ICompteService;

@Controller
@RequestMapping(value="/compteBancaire")
public class CompteBancaireController {
	
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
	
	@RequestMapping(method = RequestMethod.GET)
	public String listClients(ModelMap pModel) {
		final List<Client> lClients = clientService.listeClients();
        pModel.addAttribute("clients", lClients);
       
        return "compteBancaire/client"; //jsp de redirection 
	}
	
	
	
	@RequestMapping(value="/comptes", method = RequestMethod.GET)
	public String listeComptes(ModelMap pModel, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// Redirection si le conseiller n'est pas connecté
		HttpSession session = request.getSession();
		if (session.getAttribute("conseiller") == null) {
			request.getRequestDispatcher("connexion").forward(request, response);
		}
		
		final List<Compte> lComptes = compteService.listeComptes();
        pModel.addAttribute("comptes", lComptes);
        return "compteBancaire/compte";
	}	
}
