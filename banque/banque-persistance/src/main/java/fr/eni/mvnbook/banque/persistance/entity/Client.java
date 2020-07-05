package fr.eni.mvnbook.banque.persistance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "client")
@NamedQueries({
	@NamedQuery(name = "tous.les.clients", query = "from Client as c"),
	@NamedQuery(name = "clients.par.nom.et.prenom", query = "from Client as c where c.nom=:leNom and c.prenom=:lePrenom"),
})
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	
	@NotNull
	private long id;
	
	@Column(name = "nom", nullable = false, length = 100)
	
	@NotNull
	@Size(max = 100)
	private String nom;
	
	@Column(name = "prenom", nullable = false, length = 50)
	
	@NotNull
	@Size(max = 50)
	private String prenom;
	
	@Column(name = "adresse", nullable = false, length = 200)
	
	@NotNull
	@Size(max = 200)
	private String adresse;
	
	@Column(name = "codepostal", nullable = false, length = 5)
	
	@NotNull
	@Size(max = 5)
	@Pattern(regexp = "[0-9]{5}", message = "{fr.eni.mvnbook.banque.persistance.entity.codepostal.message}")
	private String codePostal;
	
	@Column(name = "ville", nullable = false, length = 200)
	
	@NotNull
	@Size(max = 200)
	private String ville;
	
	@Column(name = "motdepasse", nullable = false, length = 100)
	
	@NotNull
	@Size(max = 100)
	private String motDePasse;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Client) {
			Client client = (Client) obj;
			return this.id == client.id;
		}
		return false;
	}
}
