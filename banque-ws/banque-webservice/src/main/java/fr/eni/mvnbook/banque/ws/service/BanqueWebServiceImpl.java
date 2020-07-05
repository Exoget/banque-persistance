package fr.eni.mvnbook.banque.ws.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import fr.eni.mvnbook.banque.metier.BanqueService;
import fr.eni.mvnbook.banque.persistance.entity.Client;
import fr.eni.mvnbook.banque.persistance.entity.Compte;
import fr.eni.mvnbook.banque.persistance.util.BanqueException;

@WebService(endpointInterface = "fr.eni.mvnbook.banque.ws.service.BanqueWebService")
public class BanqueWebServiceImpl implements BanqueWebService {

	@Autowired
	private BanqueService banqueService;
	
	@Override
	public Client authentifier(long idClient, String password) throws BanqueException {
		return banqueService.authentifier(idClient, password);
	}

	@Override
	public List<Compte> mesComptes(long idClient) throws BanqueException {
		return banqueService.mesComptes(idClient);
	}

	@Override
	public void virement(long numeroDebit, long numeroCredit, double montant) throws BanqueException {
		banqueService.virement(numeroDebit, numeroCredit, montant);		
	}

}
