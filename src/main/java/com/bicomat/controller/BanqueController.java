package com.bicomat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bicomat.bean.Banque;
import com.bicomat.service.IBanqueService;

@Controller
@RequestMapping(value="/banques")
public class BanqueController {
	
	@Autowired
	private IBanqueService banqueService;
	
	@Autowired(required=true)
	@Qualifier(value="banqueService")
	public void setBanqueService(IBanqueService bs){
		this.banqueService = bs;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String listPersons(ModelMap pModel) {
		final List<Banque> lBanques = banqueService.listeBanques();
        pModel.addAttribute("banques", lBanques);
        return "banque";
	}	
}
