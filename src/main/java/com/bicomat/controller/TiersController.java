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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bicomat.bean.Client;
import com.bicomat.bean.Tiers;
import com.bicomat.service.IClientService;
import com.bicomat.service.ITiersService;

@Controller

public class TiersController {
	
	@Autowired
	private ITiersService tiersService;
	private IClientService clientService;
	
	@Autowired(required=true)
	@Qualifier(value="tiersService")
	public void settiersService(ITiersService ts){
		this.tiersService = ts;
	}
	@Autowired(required=true)
	@Qualifier(value="clientService")
	public void setclientService(IClientService cs){
		this.clientService = cs;
	}
	
	@RequestMapping(value="/tiers",method = RequestMethod.GET)
	public String listPersons(ModelMap pModel,HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Redirection si le conseiller n'est pas connecté
				HttpSession session = request.getSession();
				if (session.getAttribute("conseiller") == null) {
					request.getRequestDispatcher("connexion").forward(request, response);
				}
				
		// renvoie la liste des tiers		
		final List<Tiers> lTierss = tiersService.listeTiers();
        pModel.addAttribute("Tiers", lTierss);
       //renvoie la liste des clients
        final List<Client> lClients = clientService.listeClients();
		pModel.addAttribute("clients", lClients);	
        return "tiers/tiers"; //jsp de redirection 
	}
	
	/*@RequestMapping(value="/ajouttiers",method = RequestMethod.GET)
	public String creerClient(Model Model) {
		
        Model.addAttribute("creertiers", new Tiers());
       
        return "tiers/formtiers"; //jsp de redirection 
	}*/
	
	@RequestMapping(value="/ajouttiers",method = RequestMethod.POST)
	public String addtiers(HttpServletRequest response) {
		Tiers tiers =new Tiers();
		tiers.setNom(response.getParameter("nom"));
		tiers.setPrenom(response.getParameter("prenom"));
		tiers.setNumCompte(response.getParameter("num"));
		tiers.setIdclientT(Integer.parseInt(response.getParameter("id_client")));
	   
		
		
	    tiersService.creerTiers(tiers);
		
       
        return "tiers/formtiers"; //jsp de redirection 
	}
	
	@RequestMapping(value="/creertiers", method = RequestMethod.GET)
	public String afficherFormulaire(ModelMap pModel,
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// Redirection si le conseiller n'est pas connecté
				HttpSession session = request.getSession();
				if (session.getAttribute("conseiller") == null) {
					request.getRequestDispatcher("connexion").forward(request, response);
				}
				
		//Récupération de la liste des clients pour le formulaire		
		final List<Client> lClients = clientService.listeClients();
		pModel.addAttribute("clients", lClients);	
				
		return "tiers/creerTiers";
	}
	
	@RequestMapping(value="/creertiers", method = RequestMethod.POST)
	public String tiers(ModelMap pModel,HttpServletRequest request,
			@RequestParam("nom") String nomT,
			@RequestParam("prenom") String prenomT,
			@RequestParam("num") String numT,
			@RequestParam("id_client") String idClient
			
			){
		
		// on v�rifie si le tiers n'est pas d�j� rattach� au client
		if (tiersService.existeAvecNomPrenomNumCompte(nomT, prenomT,numT,Integer.parseInt(idClient))) {
			String etatTiers="Ce tiers est déjà rattaché à votre compte";
			pModel.addAttribute("etatTiers",etatTiers);
			return "tiers/creerTiers";
		}else {
		
		// sinon on créé un nouveau tiers	
		Tiers tiers=new Tiers();
		tiers.setNom(nomT);
		tiers.setPrenom(prenomT);
		tiers.setNumCompte(numT);
		tiers.setIdclientT(Integer.parseInt(idClient));
	    tiers.setDate_creation(Date.valueOf(LocalDate.now()));
		tiersService.creerTiers(tiers);
		String etatTiers="Le tiers a bien été créé";
		pModel.addAttribute("etatTiers", etatTiers);
		
		//Récupération de la liste des clients pour le formulaire		
		final List<Client> lClients = clientService.listeClients();
		pModel.addAttribute("clients", lClients);
		
		return "tiers/creerTiers";
		}
	}
}
