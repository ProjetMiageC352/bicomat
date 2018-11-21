package com.bicomat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bicomat.bean.Tiers;
import com.bicomat.service.ITiersService;

@Controller
@RequestMapping(value="/tiers")
public class TiersController {
	
	@Autowired
	private ITiersService tiersService;
	
	@Autowired(required=true)
	@Qualifier(value="tiersService")
	public void settiersService(ITiersService ts){
		this.tiersService = ts;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String listPersons(ModelMap pModel) {
		final List<Tiers> lTierss = tiersService.listeTiers();
        pModel.addAttribute("Tiers", lTierss);
       
        return "tiers"; //jsp de redirection 
	}
	

	
	
}
