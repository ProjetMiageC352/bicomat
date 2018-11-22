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

import com.bicomat.bean.CarteBancaire;
import com.bicomat.service.ICarteBancaireService;

@Controller
@RequestMapping(value="/carteBancaires")
public class CarteBancaireController {
	
	@Autowired
	private ICarteBancaireService carteBancaireService;
	
	@Autowired(required=true)
	@Qualifier(value="carteBancaireService")
	public void setCarteBancaireService(ICarteBancaireService bs){
		this.carteBancaireService = bs;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String listeCarteBancaires(ModelMap pModel, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// Redirection si le conseiller n'est pas connecté
		HttpSession session = request.getSession();
		if (session.getAttribute("conseiller") == null) {
			request.getRequestDispatcher("connexion").forward(request, response);
		}
		
		final List<CarteBancaire> lCarteBancaires = carteBancaireService.listeCarteBancaires();
        pModel.addAttribute("carteBancaires", lCarteBancaires);
        return "carteBancaire";
	}	
}
