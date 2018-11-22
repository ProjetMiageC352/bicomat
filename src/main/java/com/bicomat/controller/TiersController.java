package com.bicomat.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bicomat.bean.Tiers;
import com.bicomat.service.ITiersService;

@Controller

public class TiersController {
	
	@Autowired
	private ITiersService tiersService;
	
	@Autowired(required=true)
	@Qualifier(value="tiersService")
	public void settiersService(ITiersService ts){
		this.tiersService = ts;
	}
	
	@RequestMapping(value="/tiers",method = RequestMethod.GET)
	public String listPersons(ModelMap pModel) {
		final List<Tiers> lTierss = tiersService.listeTiers();
        pModel.addAttribute("Tiers", lTierss);
       
        return "tiers"; //jsp de redirection 
	}
	
	@RequestMapping(value="/ajouttiers",method = RequestMethod.GET)
	public String creerClient(Model Model) {
		
        Model.addAttribute("creertiers", new Tiers());
       
        return "formtiers"; //jsp de redirection 
	}
	
	@RequestMapping(value="/ajouttiers",method = RequestMethod.POST)
	public String addtiers(HttpServletRequest response) {
		Tiers tiers =new Tiers();
		tiers.setNom(response.getParameter("nom"));
		tiers.setPrenom(response.getParameter("prenom"));
		tiers.setNumCompte(response.getParameter("num"));
		tiers.setIdclientT(Integer.parseInt(response.getParameter("id_client")));
	    if (response.getParameter("actif")=="true"){
	    	tiers.setActif(true);
	    }else {
	    	tiers.setActif(false);
	    }
	    tiersService.creerTiers(tiers);
		
       
        return "formtiers"; //jsp de redirection 
	}
	
	@RequestMapping(value="/creertiers", method = RequestMethod.GET)
	public String afficherFormulaire(ModelMap pModel,
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// Redirection si le conseiller n'est pas connectÃ©
				/*HttpSession session = request.getSession();
				if (session.getAttribute("conseiller") == null) {
					request.getRequestDispatcher("connexion").forward(request, response);
				}*/
		return "creerTiers";
	}
	
	@RequestMapping(value="/creertiers", method = RequestMethod.POST)
	public String tiers(ModelMap pModel,HttpServletRequest request,
			@RequestParam("nom") String nomT,
			@RequestParam("prenom") String prenomT,
			@RequestParam("num") String numT,
			@RequestParam("id_client") String idClient,
			@RequestParam("actif") boolean actifC
			){
		
		if (tiersService.existeAvecNomPrenomNumCompte(nomT, prenomT,numT,Integer.parseInt(idClient))) {
			String etatTiers="Ce tiers est déjà rattaché à votre compte";
			pModel.addAttribute("etatTiers",etatTiers);
			return "creerTiers";
		}else {
		
		Tiers tiers=new Tiers();
		tiers.setNom(nomT);
		tiers.setPrenom(prenomT);
		tiers.setNumCompte(numT);
		tiers.setIdclientT(Integer.parseInt(idClient));
	    if (actifC==true){
	    	tiers.setActif(true);
	    }else {
	    	tiers.setActif(false);
	    }
		tiersService.creerTiers(tiers);
		String etatTiers="Le tiers a bien été créé";
		pModel.addAttribute("etatTiers", etatTiers);
		return "creerTiers";
		}
	}
}
