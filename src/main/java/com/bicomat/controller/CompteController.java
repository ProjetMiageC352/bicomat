package com.bicomat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bicomat.bean.Compte;
import com.bicomat.service.ICompteService;

@Controller
@RequestMapping(value="/comptes")
public class CompteController {
	
	@Autowired
	private ICompteService compteService;
	
	@Autowired(required=true)
	@Qualifier(value="compteService")
	public void setCompteService(ICompteService cs){
		this.compteService = cs;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String listeComptes(ModelMap pModel) {
		final List<Compte> lComptes = compteService.listeComptes();
        pModel.addAttribute("comptes", lComptes);
        return "compte";
	}	
}
