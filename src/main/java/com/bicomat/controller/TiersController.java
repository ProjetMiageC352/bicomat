package com.bicomat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value="/creertiers",method = RequestMethod.GET)
	public String creerClient(Model Model) {
		
        Model.addAttribute("creertiers", new Tiers());
       
        return "formtiers"; //jsp de redirection 
	}
	
	@RequestMapping(value="/creertiers",method = RequestMethod.POST)
	public String addtiers(HttpServletRequest response) {
		Tiers tiers =new Tiers();
		tiers.setNumCompte(Integer.parseInt(response.getParameter("num")));
	    if (response.getParameter("actif")=="true"){
	    	tiers.setActif(true);
	    }else {
	    	tiers.setActif(false);
	    }
	    tiersService.creerTiers(tiers);
		
       
        return "formtiers"; //jsp de redirection 
	}
	
}
