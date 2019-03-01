package org.greta.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance
@DiscriminatorColumn(name="TYPE_OPE",discriminatorType=DiscriminatorType.STRING,length=2)
public abstract class Operation implements Serializable{
	@Id @GeneratedValue
	private Long numOperation;
	private Date dateOperation;
	private double montant;
	@ManyToOne
	@JoinColumn(name="CODE_CPTE")
	private Compte comptes;
	
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Operation(Date dateOperation, double montant, Compte comptes) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.comptes = comptes;
	}

	public Long getNumOperation() {
		return numOperation;
	}

	public void setNumOperation(Long numOperation) {
		this.numOperation = numOperation;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Compte getComptes() {
		return comptes;
	}

	public void setComptes(Compte comptes) {
		this.comptes = comptes;
	}
	
	

}
