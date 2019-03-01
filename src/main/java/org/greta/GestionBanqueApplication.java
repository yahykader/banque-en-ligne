package org.greta;

import java.util.Date;

import org.greta.dao.ClientRepositroy;
import org.greta.dao.CompteRepository;
import org.greta.dao.OperationRepository;
import org.greta.entities.Client;
import org.greta.entities.Compte;
import org.greta.entities.CompteCourant;
import org.greta.entities.CompteEpargne;
import org.greta.entities.Operation;
import org.greta.entities.Retrait;
import org.greta.entities.Versement;
import org.greta.service.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionBanqueApplication implements CommandLineRunner{
	@Autowired
	private ClientRepositroy clientRepositroy;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
    private	IBanqueMetier banqueMetier;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionBanqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		
		  //AJOUTER DES CLIENTS 
		 //Client c1= clientRepositroy.save(new Client("Abdelkader","abdelkader@gmail.com"));
		  //Client c2= clientRepositroy.save(new Client("Nesrine","nesrine@gmail.com")); 
//		  Client c3= clientRepositroy.save(new Client("Mounir","mounir@laposte.fr")); 
//		  Client c4= clientRepositroy.save(new Client("Zohra","zohra@yahoo.com"));
//		  
//		  
//		  // AJOUTER DES COMPTES ASSOCIES A DES CLIENTS 
		//  Compte cp1=compteRepository.save(new CompteCourant("c1", new Date(), 5000, c1,1000));  
		//  Compte cp2=compteRepository.save(new CompteEpargne("c2", new Date(),10000, c1, 5.5));
//		  
//		  Compte cp3=compteRepository.save(new CompteCourant("c3", new Date(), 2500,c2, 1200)); 
//		  Compte cp4=compteRepository.save(new CompteEpargne("c4", new Date(), 120, c2, 5.0));
//		  
//		  
//		  Compte cp5=compteRepository.save(new CompteCourant("c5", new Date(), 3500,c3, 450)); 
//		  Compte cp6=compteRepository.save(new CompteEpargne("c6", new Date(), 120, c3, 5.0));
//		  
//		  
//		  Compte cp7=compteRepository.save(new CompteCourant("c7", new Date(), 3500,c4, 420)); 
//		  Compte cp8=compteRepository.save(new CompteEpargne("c8", new Date(), 120, c4, 6.5));
		  
		  
		  // AJOUTER DES OPERATIONS ASSOCIES A DES COMPTES
		  
		  
//	      Operation op1=operationRepository.save(new Versement(new Date(),1200, cp1));
//		  //Operation op11=operationRepository.save(new Versement(new Date(),5200, cp1)); 
//		  Operation op12=operationRepository.save(new Retrait(new Date(), 2200,cp1));
//		  
//		  Operation op2=operationRepository.save(new Versement(new Date(), 8200, cp2));
//		  Operation op21=operationRepository.save(new Retrait(new Date(), 4000, cp2));
//		  
//		  Operation op3=operationRepository.save(new Versement(new Date(), 1200, cp3));
//		  Operation op31=operationRepository.save(new Versement(new Date(), 7200,cp3)); 
//		  Operation op32=operationRepository.save(new Retrait(new Date(), 8200,cp3));
//		  
//		  Operation op4=operationRepository.save(new Versement(new Date(), 7200, cp4));
//		  Operation op41=operationRepository.save(new Retrait(new Date(), 4000, cp4));
//		  
//		  Operation op5=operationRepository.save(new Versement(new Date(), 1200, cp5));
//		  Operation op51=operationRepository.save(new Versement(new Date(), 5200,cp5)); 
//		  Operation op52=operationRepository.save(new Retrait(new Date(), 4000,cp5));
//		  
//		  Operation op6=operationRepository.save(new Retrait(new Date(), 4000, cp6));
//		  Operation op61=operationRepository.save(new Versement(new Date(), 4000,cp6));
//		  Operation op62=operationRepository.save(new Retrait(new Date(), 4000,cp6));
//		  
//		  Operation op7=operationRepository.save(new Versement(new Date(), 800, cp7));
//		  Operation op71=operationRepository.save(new Versement(new Date(),500, cp7));
//		  Operation op72=operationRepository.save(new Retrait(new Date(),900, cp7));
//		  
//		  Operation op8=operationRepository.save(new Versement(new Date(), 800, cp8));
//		  Operation op81=operationRepository.save(new Versement(new Date(),500, cp8));
//		  Operation op82=operationRepository.save(new Retrait(new Date(), 4000, cp8));
		 
		 // banqueMetier.consulterCompte("c1");
		 
		// banqueMetier.verser("c2",11111);
		 // banqueMetier.retirer("c2", 8000);
		//banqueMetier.virement("c1", "c2", 5000);
		  
	}

}

