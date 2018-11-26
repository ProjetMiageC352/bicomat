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
import com.bicomat.bean.Operation;
import com.bicomat.service.IClientService;
import com.bicomat.service.IOperationService;

@Controller

public class OperationController {
	
	@Autowired
	private IOperationService operationService;
	
	@Autowired(required=true)
	@Qualifier(value="operationService")
	public void setOperationService(IOperationService cs){
		this.operationService = cs;
	}
	
	// Affichage du formulaire de cr�ation de compte Agency pour un client
				@RequestMapping(value="/client/operation/{nom}/{prenom}/{type}/{id}/{solde}", method = RequestMethod.GET)
				public String affichelistecompteparclient(ModelMap pModel,
						@PathVariable(value="nom") final String nom,
						@PathVariable(value="prenom") final String prenom,
						@PathVariable(value="type") final String type_compte,
						@PathVariable(value="id") final int id_compte,
						@PathVariable(value="solde") final double solde_compte,
						HttpServletRequest request,
						HttpServletResponse response) throws ServletException, IOException {
					
					// Redirection si le conseiller n'est pas connect�
					HttpSession session = request.getSession();
					if (session.getAttribute("conseiller") == null) {
						request.getRequestDispatcher("connexion").forward(request, response);
					}
					
					final List<Operation> lOperation = operationService.listeOperationsParCompte(id_compte);
					pModel.addAttribute("nom", nom);
					pModel.addAttribute("prenom", prenom);
					pModel.addAttribute("type_compte", type_compte);
			        pModel.addAttribute("operations", lOperation);
			        pModel.addAttribute("solde", solde_compte);
					
					
			        return "client/operations";
				}
}
