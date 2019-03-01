package org.greta.service;

import org.greta.entities.Compte;
import org.greta.entities.Operation;
import org.springframework.data.domain.Page;

public interface IBanqueMetier {
	
	//couche metier represente les besoins fonctionnelles des l'applacation
	//le diagramme cas d'ulisation ce traduit par un interface qui represente la couche metier
	
	public Compte consulterCompte(String codeCompte);
	public void verser(String codeCompte,double montant);
	public void retirer(String codeCompte,double montant);
	public void virement(String codeCompte1,String codeCompte2,double montant);
	public Page<Operation> ListOperations(String codeCompte,int page,int size);
	
	

}
