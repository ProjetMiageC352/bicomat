package com.bicomat.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value= {"", "/", "/accueil"})
public class AccueilController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String listeBanques(ModelMap pModel, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// Redirection si le conseiller n'est pas connecté
		HttpSession session = request.getSession();
		if (session.getAttribute("conseiller") == null) {
			request.getRequestDispatcher("connexion").forward(request, response);
		}
		
		return "accueil";
	}	
}
