package org.greta.web;

import org.greta.entities.Compte;

import org.greta.entities.Operation;
import org.greta.service.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BanqueController {
	@Autowired
	private IBanqueMetier banqueMetier;
	
	
	@RequestMapping(value="/operations")
	public String index() {
		
		return"compte";
	} 
	
	@RequestMapping(value="/consulterCompte")
	public String consulterCompte(Model model,String codeCompte,
			@RequestParam(value="page",defaultValue="0") int page,
			@RequestParam(value="size",defaultValue="5") int size) {
		model.addAttribute("codeCompte",codeCompte);
		try {
		  Compte cp=banqueMetier.consulterCompte(codeCompte);
		    Page<Operation> pageOperations=banqueMetier.ListOperations(codeCompte,page,size);
		  model.addAttribute("listOperations",pageOperations.getContent());  
		  int [] pages=new int [pageOperations.getTotalPages()];
		  model.addAttribute("pages",pages);
		  model.addAttribute("compte",cp);
		}catch(Exception e) 
		 {
			model.addAttribute("exception",e);
		 }
		
		return"compte";
	}
	
	@RequestMapping(value="/saveOperation",method = RequestMethod.POST)
	public String saveOperation(Model model,String codeCompte,String typeOperation, double montant,String codeCompte2 ) {
	     
		try {
			if(typeOperation.equals("VER")) {
					
				banqueMetier.verser(codeCompte,montant);
					
			}else if(typeOperation.equals("RET")) {
					
				banqueMetier.retirer(codeCompte,montant);
					
			}
			if(typeOperation.equals("VIR")) {
					
				banqueMetier.virement(codeCompte,codeCompte2,montant);	
			}
		}catch(Exception e) {
			
			model.addAttribute("error",e);
			return "redirect:/consulterCompte?codeCompte="+codeCompte+"&error="+e.getMessage();
		}
		
		return "redirect:/consulterCompte?codeCompte="+codeCompte;
	}
	
}
