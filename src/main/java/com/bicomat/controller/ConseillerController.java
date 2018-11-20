package com.bicomat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bicomat.bean.Conseiller;
import com.bicomat.service.IConseillerService;

@Controller
@RequestMapping(value="/conseillers")
public class ConseillerController {
	
	@Autowired
	private IConseillerService conseillerService;
	
	@Autowired(required=true)
	@Qualifier(value="conseillerService")
	public void setConseillerService(IConseillerService cs){
		this.conseillerService = cs;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String listeConseillers(ModelMap pModel) {
		final List<Conseiller> lConseillers = conseillerService.listeConseillers();
        pModel.addAttribute("conseillers", lConseillers);
        return "conseiller";
	}	
}
