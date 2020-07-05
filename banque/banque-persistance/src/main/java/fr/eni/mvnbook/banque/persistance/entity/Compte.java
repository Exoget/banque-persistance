package fr.eni.mvnbook.banque.persistance.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "compte")
@NamedQueries({
	@NamedQuery(name = "rechercher.comptes.client", query = "from Compte as c where c.client=:leClient"),
	@NamedQuery(name = "rechercher.comptes.debiteurs", query = "from Compte as c where c.solde < 0")
})
public class Compte {

	@Id
	@Column(name = "numero")
	private long numero;
	
	@Column(name = "solde", precision = 10, scale = 2)
	private double solde;
	
	@ManyToOne(targetEntity = Client.class, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idclient")
	private Client client;

	public Compte() { } 
	
	public Compte(long numero, double solde, Client client) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.client = client;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Compte) {
			Compte compte = (Compte) obj;
			return this.numero == compte.numero;
		}
		return false;
	}
}
