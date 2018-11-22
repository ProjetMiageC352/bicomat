package com.bicomat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bicomat.bean.Client;
import com.bicomat.service.IClientService;

@Controller
@RequestMapping()
public class ClientController {
	
	@Autowired
	private IClientService clientService;
	
	@Autowired(required=true)
	@Qualifier(value="clientService")
	public void setclientService(IClientService cs){
		this.clientService = cs;
	}
	
	@RequestMapping(value="/clients",method = RequestMethod.GET)
	public String listPersons(ModelMap pModel) {
		final List<Client> lClients = clientService.listeClients();
        pModel.addAttribute("clients", lClients);
       
        return "client"; //jsp de redirection 
	}
	
	@RequestMapping(value="/creerclients",method = RequestMethod.GET)
	public String creerClient(Model Model) {
		
        Model.addAttribute("creerclient", new Client());
       
        return "formclient"; //jsp de redirection 
	}
	
	@RequestMapping(value="/creerclients", method = RequestMethod.POST)
    public String addclient( HttpServletRequest response) {
     Client client= new Client();
     client.setNom(response.getParameter("nom"));
     client.setPrenom(response.getParameter("prenom"));
     client.setAdresse_mail(response.getParameter("adresse"));
     client.setTel_client(Integer.parseInt(response.getParameter("tel")));
     client.setNum_contrat(Integer.parseInt(response.getParameter("contrat")));
     client.setId_conseiller(Integer.parseInt(response.getParameter("conseiller")));
     client.setNum_contrat(Integer.parseInt(response.getParameter("contrat")));
     client.setLogin(response.getParameter("login"));
     client.setPassword(response.getParameter("password"));
      clientService.creerClient(client);
      return "formclient";
    }
	
}
