package org.greta.entities;


import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="V")
public class Versement extends Operation {

	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement(Date dateOperation, double montant, Compte comptes) {
		super(dateOperation, montant, comptes);
		// TODO Auto-generated constructor stub
	}

	

	
	
	

}
