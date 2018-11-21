package com.bicomat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bicomat.bean.Client;
import com.bicomat.service.IClientService;

@Controller
@RequestMapping(value="/creerclients")
public class CreerClientController {
	

	@RequestMapping(method = RequestMethod.GET)
	public String creerClient(Model Model) {
		
        Model.addAttribute("creerclient", new Client());
       
        return "formclient"; //jsp de redirection 
	}
	
	private IClientService clientService;
	@Autowired
	public void setclientService(IClientService cs){
		this.clientService = cs;
	}
	
	@RequestMapping( method = RequestMethod.POST)
    public String addclient( HttpServletRequest response) {
     Client client= new Client();
     client.setNom(response.getParameter("nom"));
     client.setPrenom(response.getParameter("prenom"));
     client.setAdresse_mail(response.getParameter("adresse"));
     client.setType_client(response.getParameter("type"));
      clientService.creerClient(client);
      return "formclient";
    }
	
	
}
