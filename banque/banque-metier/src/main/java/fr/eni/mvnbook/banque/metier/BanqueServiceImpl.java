package fr.eni.mvnbook.banque.metier;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;

import fr.eni.mvnbook.banque.persistance.dao.ClientDAO;
import fr.eni.mvnbook.banque.persistance.dao.CompteDAO;
import fr.eni.mvnbook.banque.persistance.entity.Client;
import fr.eni.mvnbook.banque.persistance.entity.Compte;
import fr.eni.mvnbook.banque.persistance.util.BanqueException;

@Component(value = "banqueService")
public class BanqueServiceImpl implements BanqueService {

	@Inject
	@Named("compteDAO")
	private CompteDAO compteDAO;
	
	@Inject
	@Named("clientDAO")
	private ClientDAO clientDAO;

	public Client authentifier(long idClient, String password) throws BanqueException {
		try {
			Client client = clientDAO.rechercherClientParId(idClient);
			if(
				client != null && 
				password != null &&
				password.equals(client.getMotDePasse())
			) {
				return client;
			}
			else {
				throw new Exception();
			}
		} 
		catch (Exception e) {
			throw new BanqueException("Erreur d'authentification.");
		}
	}

	public List<Compte> mesComptes(long idClient) throws BanqueException {
		Client client = clientDAO.rechercherClientParId(idClient);
		return compteDAO.rechercherComptesClient(client);
	}

	public void virement(long numeroDebit, long numeroCredit, double montant) throws BanqueException {
		try {
			Compte aDebiter = compteDAO.rechercherCompteParNumero(numeroDebit);
			Compte aCrediter = compteDAO.rechercherCompteParNumero(numeroCredit);

			aDebiter.setSolde(aDebiter.getSolde() - montant);
			aCrediter.setSolde(aCrediter.getSolde() + montant);
			
			compteDAO.modifierCompte(aDebiter);
			compteDAO.modifierCompte(aCrediter);
		} 
		catch (Exception e) {
			throw new BanqueException("Erreur lors de la réalisation du virement.");	
		}
	}

}














