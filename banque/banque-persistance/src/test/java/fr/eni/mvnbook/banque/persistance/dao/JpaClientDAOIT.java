package fr.eni.mvnbook.banque.persistance.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.eni.mvnbook.banque.config.ConfigurationPersistanceIntegration;
import fr.eni.mvnbook.banque.persistance.entity.Client;
import fr.eni.mvnbook.banque.persistance.util.BanqueException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfigurationPersistanceIntegration.class)
@Transactional
public class JpaClientDAOIT {

	@Inject
	private ClientDAO clientDAO;

	@Test
	public void testAjouterClient() throws BanqueException {
		Client client = new Client();

		client.setNom("DUPONT");
		client.setPrenom("Robert");
		client.setAdresse("40 rue de la Paix");
		client.setCodePostal("44300");
		client.setVille("Nantes");
		client.setMotDePasse("secret");

		clientDAO.ajouterClient(client);

		Client clientRecupere = clientDAO.rechercherClientParId(5);
		assertThat(clientRecupere).isNotNull();
		assertThat(clientRecupere.getId()).isEqualTo(5);
	}

	@Test
	public void testRechercherClientParId() throws BanqueException {
		Client client = clientDAO.rechercherClientParId(2L);

		assertThat(client).isNotNull();

		assertThat(client.getId()).isEqualTo(2);
		assertThat(client.getPrenom()).isEqualTo("Bruno");
		assertThat(client.getNom()).isEqualTo("DRUAND");
		assertThat(client.getAdresse()).isEqualTo("Place de Bretagne");
		assertThat(client.getCodePostal()).isEqualTo("35000");
		assertThat(client.getVille()).isEqualTo("Rennes");
		assertThat(client.getMotDePasse()).isEqualTo("password");
	}

	@Test
	public void testRechercherTousLesClients() throws BanqueException {
		List<Client> listeClients = clientDAO.rechercherTousLesClients();
		assertThat(listeClients).isNotNull().hasSize(4);
	}

	@Test
	public void testRechercherClientsParNomEtPrenom() throws BanqueException {
		List<Client> listeClients1 = clientDAO.rechercherClientsParNomEtPrenom("DUPONT", "Robert");
		assertThat(listeClients1).isNotNull().hasSize(1);
		List<Client> listeClients2 = clientDAO.rechercherClientsParNomEtPrenom("DRUAND", "Bruno");
		assertThat(listeClients2).isNotNull().hasSize(1);
	}

	@Test
	public void testModifierClient() throws BanqueException {
		Client client = new Client();
		client.setId(1L);
		client.setNom("DURANT");
		client.setPrenom("Robert");
		client.setAdresse("40 rue de la Paix");
		client.setCodePostal("44300");
		client.setVille("Nantes");
		client.setMotDePasse("secret");

		clientDAO.modifierClient(client);

		Client clientRecupere = clientDAO.rechercherClientParId(1L);
		assertThat(clientRecupere).isNotNull();
		assertThat(clientRecupere.getNom()).isEqualTo("DURANT");
	}
}
