package fr.eni.mvnbook.banque.web;

import java.io.Serializable;

public class VirementForm implements Serializable {

	private static final long serialVersionUID = -7248918115165824433L;
	
	private String debiter;
	private String crediter;
	private String montant;

	public String getDebiter() {
		return debiter;
	}

	public void setDebiter(String debiter) {
		this.debiter = debiter;
	}

	public String getCrediter() {
		return crediter;
	}

	public void setCrediter(String crediter) {
		this.crediter = crediter;
	}

	public String getMontant() {
		return montant;
	}

	public void setMontant(String montant) {
		this.montant = montant;
	}
	
}
