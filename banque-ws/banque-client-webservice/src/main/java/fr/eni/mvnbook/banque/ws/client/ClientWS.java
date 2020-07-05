package fr.eni.mvnbook.banque.ws.client;

import fr.eni.mvnbook.banque.ws.client.proxy.BanqueException_Exception;
import fr.eni.mvnbook.banque.ws.client.proxy.BanqueWebServiceImplService;
import fr.eni.mvnbook.banque.ws.client.proxy.BanqueWebservice;
import fr.eni.mvnbook.banque.ws.client.proxy.Client;

/**
 * Hello world!
 *
 */
public class ClientWS {
	public static void main(String[] args) {
		try {
			BanqueWebServiceImplService proxy = new BanqueWebServiceImplService();

			BanqueWebservice service = proxy.getBanqueWebServiceImplPort();

			Client client = service.auth("ROBERT", "DUPONT");
			
			System.out.println("Client authentifié : " + client.getId());
		} 
		catch (BanqueException_Exception e) {
			e.printStackTrace();
		}
	}
}
