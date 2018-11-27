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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bicomat.bean.Client;
import com.bicomat.bean.Compte;
import com.bicomat.service.IClientService;
import com.bicomat.service.ICompteService;

@Controller

public class FicheClientController {
	
	@Autowired
	private ICompteService compteService;
	
	@Autowired(required=true)
	@Qualifier(value="compteService")
	public void setCompteService(ICompteService cs){
		this.compteService = cs;
	}
	
	// Affichage du formulaire de création de compte Agency pour un client
				@RequestMapping(value="/client/fiche/{nom}&{prenom}&{num_contrat}&{id}&{mail}&{tel}&{login}", method = RequestMethod.GET)
				public String affichelistecompteparclient(ModelMap pModel,
						@PathVariable(value="nom") final String nom,
						@PathVariable(value="prenom") final String prenom,
						@PathVariable(value="num_contrat") final String num_contrat,
						@PathVariable(value="id") final int id_client,
						@PathVariable(value="mail") final String mail,
						@PathVariable(value="tel") final String tel,
						@PathVariable(value="login") final String login,
						HttpServletRequest request,
						HttpServletResponse response) throws ServletException, IOException {
					
					// Redirection si le conseiller n'est pas connecté
					HttpSession session = request.getSession();
					if (session.getAttribute("conseiller") == null) {
						request.getRequestDispatcher("connexion").forward(request, response);
					}
					pModel.addAttribute("nom", nom);
					pModel.addAttribute("prenom", prenom);
					pModel.addAttribute("num_contrat", num_contrat);
					pModel.addAttribute("mail", mail);
					pModel.addAttribute("tel", tel);
					pModel.addAttribute("login", login);
					pModel.addAttribute("id", id_client);
					final List<Compte> lCcompte = compteService.listeComptesOuvertparclient(id_client);
			        pModel.addAttribute("comptes", lCcompte);
					
					
			        return "client/fiche";
				}
}
