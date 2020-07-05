package fr.eni.mvnbook.banque.metier;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import fr.eni.mvnbook.banque.persistance.entity.Client;
import fr.eni.mvnbook.banque.persistance.entity.Compte;
import fr.eni.mvnbook.banque.persistance.util.BanqueException;

public interface BanqueService {

	@Transactional(value = TxType.SUPPORTS, rollbackOn = BanqueException.class)
	public abstract Client authentifier(long idClient, String password)
		throws BanqueException;
	
	@Transactional(value = TxType.SUPPORTS, rollbackOn = BanqueException.class)
	public abstract List<Compte> mesComptes(long idClient) 
		throws BanqueException;
	
	@Transactional(value = TxType.REQUIRED, rollbackOn = BanqueException.class)
	public abstract void virement(
		long numeroDebit, long numeroCredit, double montant
	) throws BanqueException;

}












