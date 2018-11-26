package com.bicomat.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.bicomat.bean.Client;
import com.bicomat.bean.Compte;
import com.bicomat.bean.Operation;
import com.bicomat.service.IClientService;
import com.bicomat.service.ICompteService;
import com.bicomat.service.IOperationService;

@Controller

public class ClotureCompteController {
	
	@Autowired
	private IOperationService operationService;
	
	@Autowired(required=true)
	@Qualifier(value="operationService")
	public void setOperationService(IOperationService cs){
		this.operationService = cs;
	}
	
	// Affichage du formulaire de création de compte Agency pour un client
				@RequestMapping(value="/compteBancaire/cloture/{id}/{solde}/{type}", method = RequestMethod.GET)
				public String affichepagecloture(ModelMap pModel,
						@PathVariable(value="id") final int id_compte,
						@PathVariable(value="solde") final double solde,
						@PathVariable(value="type") final String type_compte,
						HttpServletRequest request,
						HttpServletResponse response) throws ServletException, IOException {
					
					/*// Redirection si le conseiller n'est pas connecté
					HttpSession session = request.getSession();
					if (session.getAttribute("conseiller") == null) {
						request.getRequestDispatcher("connexion").forward(request, response);
					}*/
					pModel.addAttribute("id", id_compte);
					pModel.addAttribute("solde", solde);
					pModel.addAttribute("type", type_compte);
					
					
					
			        return "compteBancaire/cloture";
				}
				
				// Affichage du formulaire de création de compte Agency pour un client
				@RequestMapping(value="/compteBancaire/cloture", method = RequestMethod.POST)
				public String cloturecompte(ModelMap pModel,
						@RequestParam("id_compte") int id,
						@RequestParam("montant") double montant_solde,
						@RequestParam("type") String type_compte,
						HttpServletRequest request
						) throws ServletException, IOException {
					
					/*// Redirection si le conseiller n'est pas connecté
					HttpSession session = request.getSession();
					if (session.getAttribute("conseiller") == null) {
						request.getRequestDispatcher("connexion").forward(request, response);
					}*/
					Date date = new Date();
					
					Operation op=new Operation();
					op.setIdCompte(id);
					op.setMontant(montant_solde);
					op.setType("Cloture du compte "+type_compte);
					op.setDate(date);
					operationService. ajouterOperation(op);
					
			        return "compteBancaire/cloture";
				}
}
