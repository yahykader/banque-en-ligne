package org.greta.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="R")
public class Retrait extends Operation {

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(Date dateOperation, double montant, Compte comptes) {
		super(dateOperation, montant, comptes);
		// TODO Auto-generated constructor stub
	}
	
	

}
