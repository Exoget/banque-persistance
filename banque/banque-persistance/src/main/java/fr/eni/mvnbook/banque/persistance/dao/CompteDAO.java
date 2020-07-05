package fr.eni.mvnbook.banque.persistance.dao;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import fr.eni.mvnbook.banque.persistance.entity.Client;
import fr.eni.mvnbook.banque.persistance.entity.Compte;
import fr.eni.mvnbook.banque.persistance.util.BanqueException;

public interface CompteDAO {

	@Transactional(value = TxType.REQUIRED, rollbackOn = BanqueException.class)
	public abstract void ajouterCompte(Compte compte) throws BanqueException;
	
	@Transactional(value = TxType.SUPPORTS, rollbackOn = BanqueException.class)
	public abstract Compte rechercherCompteParNumero(long numero) throws BanqueException;
	
	@Transactional(value = TxType.SUPPORTS, rollbackOn = BanqueException.class)	
	public abstract List<Compte> rechercherComptesClient(Client client) throws BanqueException;
	
	@Transactional(value = TxType.SUPPORTS, rollbackOn = BanqueException.class)
	public abstract List<Compte> rechercherComptesDebiteurs() throws BanqueException;
	
	@Transactional(value = TxType.REQUIRED, rollbackOn = BanqueException.class)
	public abstract void modifierCompte (Compte compte) throws BanqueException;
	
	@Transactional(value = TxType.REQUIRED, rollbackOn = BanqueException.class)
	public abstract void supprimerCompte (Compte compte) throws BanqueException;
	
}









