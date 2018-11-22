package com.bicomat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bicomat.service.IConseillerService;

@Controller
public class ConnexionController {
	
	@Autowired
	private IConseillerService conseillerService;
	
	@Autowired(required=true)
	@Qualifier(value="conseillerService")
	public void setConseillerService(IConseillerService cs){
		this.conseillerService = cs;
	}
	
	@RequestMapping(value="/connexion", method = RequestMethod.GET)
	public String afficherFormulaire(ModelMap pModel,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String etatConnexion = "non connecté";
		if (session.getAttribute("conseiller") != null) {
			etatConnexion = "connecté " + session.getAttribute("conseiller");
		}
		pModel.addAttribute("etatConnexion", etatConnexion);
		
		return "connexion";
	}
	
	@RequestMapping(value="/connexion", method = RequestMethod.POST)
	public String connexion(ModelMap pModel,
			HttpServletRequest request,
			@RequestParam("login") String login,
			@RequestParam("password") String password) {
		
		HttpSession session = request.getSession();
		if (conseillerService.existeAvecLoginPassword(login, password)) {
			session.setAttribute("conseiller", login);
		}
		
		String etatConnexion = "non connecté";
		if (session.getAttribute("conseiller") != null) {
			etatConnexion = "connecté " + session.getAttribute("conseiller");
		}
		pModel.addAttribute("etatConnexion", etatConnexion);
		
		return "connexion";
	}
	
	@RequestMapping(value="/deconnexion", method = RequestMethod.GET)
	public String deconnexion(ModelMap pModel,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("conseiller", null);
		
		String etatConnexion = "non connecté";
		if (session.getAttribute("conseiller") != null) {
			etatConnexion = "connecté " + session.getAttribute("conseiller");
		}
		pModel.addAttribute("etatConnexion", etatConnexion);
		
		return "connexion";
	}
}
