package org.greta.service;

import java.util.Date;

import java.util.Optional;
import org.greta.dao.CompteRepository;
import org.greta.dao.OperationRepository;
import org.greta.entities.Compte;
import org.greta.entities.CompteCourant;
import org.greta.entities.CompteEpargne;
import org.greta.entities.Operation;
import org.greta.entities.Retrait;
import org.greta.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 /** 
 * @author abdelkader 
 * POUR QUE SPRING INSTANCIER CETTE PAGE AU DEMARAGE EN MET L'ANNOTATION @SERVICE
 * UITILISE POUR LE OBJET DE COUCHE METIER
 */
@Service
/**
 * @author abdelkader
 * POUR QUE SPRING PREND ON CHARGE TOUTE LES OPERATIONS TRANSACTIONNAL ON FAIT L'ANNOTATION @TRANSACTIONNAL
 */

@Transactional

public class BanqueMetierImpl  implements IBanqueMetier{
	/**
	 * @author abdelkader
	 * POUR FAIRE APPEL A CETTE INTERFACE ET DEMANDE A L'INJECTION DES DONNES
	 */
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	
//	@Override
//	public Compte consulterCompte(String codeCompte) {
//	
//			Compte cp=compteRepository.getOne(codeCompte);
//			
//			if(cp==null) throw new RuntimeException ("Compte Introuvable");
//			
//		return cp;
//		
//	}
//	
	
	@Override
    public Compte consulterCompte(String codeCompte) throws RuntimeException {
		
        Optional<Compte> cp = compteRepository.findById(codeCompte);
        return cp.orElseThrow(
                () ->  new RuntimeException(" Compte Introuvable, Veuillez saisir un Compte Existe...  "));   
        
    }

	@Override
	public void verser(String codeCompte, double montant) {
		
		Compte cp=consulterCompte(codeCompte);
		Versement v=new Versement(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde()+montant);
		compteRepository.save(cp);
			
	}

	@Override
	public void retirer(String codeCompte, double montant) {
		Compte cp=consulterCompte(codeCompte);
		double mantantDecouvert=0;
		if(cp instanceof CompteCourant)
			  mantantDecouvert=((CompteCourant) cp).getDecouvert();
		if(cp.getSolde()+mantantDecouvert<montant) throw new RuntimeException("Solde Insuffisant... ");
		Retrait r= new Retrait(new Date(), montant, cp);
		operationRepository.save(r);
		cp.setSolde(cp.getSolde()-montant);
		compteRepository.save(cp);
	}

	@Override
	public void virement(String codeCompte1, String codeCompte2, double montant) {
		if(codeCompte1.equals(codeCompte2))
			   throw new RuntimeException("Impossible d'effectuer le Virement  sur la même compte ");
				retirer(codeCompte1, montant);
				verser(codeCompte2,montant);
	}

	@Override
	public Page<Operation> ListOperations(String codeCompte, int page, int size) {
		// TODO Auto-generated method stub
		return operationRepository.ListOperations(codeCompte,new PageRequest(page,size));
	}

}
