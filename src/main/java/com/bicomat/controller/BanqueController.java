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
	public String listeBanques(ModelMap pModel, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// Redirection si le conseiller n'est pas connecté
		HttpSession session = request.getSession();
		if (session.getAttribute("conseiller") == null) {
			request.getRequestDispatcher("connexion").forward(request, response);
		}
		
		final List<Banque> lBanques = banqueService.listeBanques();
        pModel.addAttribute("banques", lBanques);
        return "banque";
	}	
}
