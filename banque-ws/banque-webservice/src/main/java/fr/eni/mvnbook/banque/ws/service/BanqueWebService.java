package fr.eni.mvnbook.banque.ws.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import fr.eni.mvnbook.banque.persistance.entity.Client;
import fr.eni.mvnbook.banque.persistance.entity.Compte;
import fr.eni.mvnbook.banque.persistance.util.BanqueException;

@WebService(name = "BanqueWebservice", targetNamespace = "http://www.eni.fr/ws/mvnbook/banque-webservice")
public interface BanqueWebService {

	@WebMethod(operationName = "auth", exclude = false)
	public abstract Client authentifier(long idClient, String password) throws BanqueException;

	@WebMethod(operationName = "comptes", exclude = false)
	public abstract List<Compte> mesComptes(long idClient) throws BanqueException;

	@WebMethod(operationName = "virement", exclude = false)
	public abstract void virement(long numeroDebit, long numeroCredit, double montant) throws BanqueException;

}
