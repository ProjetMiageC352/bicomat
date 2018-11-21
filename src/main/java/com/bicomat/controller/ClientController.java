package com.bicomat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bicomat.bean.Client;
import com.bicomat.service.IClientService;

@Controller
@RequestMapping(value="/clients")
public class ClientController {
	
	@Autowired
	private IClientService clientService;
	
	@Autowired(required=true)
	@Qualifier(value="clientService")
	public void setclientService(IClientService cs){
		this.clientService = cs;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String listPersons(ModelMap pModel) {
		final List<Client> lClients = clientService.listeClients();
        pModel.addAttribute("clients", lClients);
       
        return "client"; //jsp de redirection 
	}
	
	/*@RequestMapping( method = RequestMethod.POST)
    public String submit( ModelMap model) {
      Client client = new Client();
        model.addAttribute("nom", client.getNom());
        model.addAttribute("prenom", client.getPrenom());
        model.addAttribute("adresse", client.getAdresse_mail());
        model.addAttribute("type", client.getType_client());
        clientService.creerClient(client);
        return "formclient";
    }*/
	
	
}
