package fr.eni.mvnbook.banque.persistance.dao;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import fr.eni.mvnbook.banque.persistance.entity.Client;
import fr.eni.mvnbook.banque.persistance.util.BanqueException;

public interface ClientDAO {

	@Transactional(value = TxType.REQUIRED, rollbackOn = BanqueException.class)
	public abstract void ajouterClient(Client client) throws BanqueException;
	
	@Transactional(value = TxType.SUPPORTS, rollbackOn = BanqueException.class)
	public abstract Client rechercherClientParId(long id) throws BanqueException;
	
	@Transactional(value = TxType.SUPPORTS, rollbackOn = BanqueException.class)
	public abstract List<Client> rechercherTousLesClients() throws BanqueException;
	
	@Transactional(value = TxType.SUPPORTS, rollbackOn = BanqueException.class)
	public abstract List<Client> rechercherClientsParNomEtPrenom(String nom, String prenom) throws BanqueException;

	@Transactional(value = TxType.REQUIRED, rollbackOn = BanqueException.class)
	public abstract void modifierClient(Client client) throws BanqueException;
	
	@Transactional(value = TxType.REQUIRED, rollbackOn = BanqueException.class)
	public abstract void supprimerClient(Client client) throws BanqueException;
	
}
