package com.bicomat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bicomat.bean.Operation;
import com.bicomat.service.IOperationService;

@Controller
@RequestMapping(value="/operations")
public class OperationController {
	
	@Autowired
	private IOperationService operationService;
	
	@Autowired(required=true)
	@Qualifier(value="operationService")
	public void setOperationService(IOperationService os){
		this.operationService = os;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String listeOperations(ModelMap pModel) {
		final List<Operation> lOperations = operationService.listeOperations();
        pModel.addAttribute("operations", lOperations);
        return "operation";
	}
}
