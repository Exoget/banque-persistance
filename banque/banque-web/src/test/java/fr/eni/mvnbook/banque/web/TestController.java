package fr.eni.mvnbook.banque.web;

import java.util.ArrayList;
import java.util.List;

import fr.eni.mvnbook.banque.persistance.entity.Client;
import fr.eni.mvnbook.banque.persistance.entity.Compte;

public class TestController {

	public Client getTestClient() {
		Client client = new Client();
		client.setId(1);
		client.setNom("DUPONT");
		client.setPrenom("Robert");
		client.setAdresse("40 rue de la Paix");
		client.setCodePostal("75007");	
		client.setVille("Paris");
		client.setMotDePasse("secret");	

		return client;
	}
	
	public List<Compte> getTestListeDesComptes(Client client) {
		Compte compte1 = new Compte(12563, 5000.00, client);
		Compte compte2 = new Compte(985632, 444.00, client);
		
		List<Compte> listeDesComptes = new ArrayList<Compte>();
		listeDesComptes.add(compte1);
		listeDesComptes.add(compte2);
		
		return listeDesComptes;
	}
	
	
}
