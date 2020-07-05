package fr.eni.mvnbook.banque.persistance.dao;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.eni.mvnbook.banque.persistance.entity.Client;
import fr.eni.mvnbook.banque.persistance.util.BanqueException;

public class JpaClientDAOTest {

	@Mock
	private EntityManager em;

	@Mock
	private Query query;

	@InjectMocks
	private JpaClientDAO clientDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAjouterClient() throws BanqueException {
		Client client = new Client();
		client.setId(1);
		client.setNom("DUPONT");
		client.setPrenom("Robert");
		client.setAdresse("40 rue de la Paix");
		client.setCodePostal("75007");
		client.setVille("Paris");
		client.setMotDePasse("secret");

		clientDAO.ajouterClient(client);

		verify(em).persist(client);
	}

	@Test
	public void testRechercherClientParId() throws BanqueException {
		Client client = new Client();
		client.setId(1);
		client.setNom("DUPONT");
		client.setPrenom("Robert");
		client.setAdresse("40 rue de la Paix");
		client.setCodePostal("75007");
		client.setVille("Paris");
		client.setMotDePasse("secret");

		when(em.find(Client.class, 1L)).thenReturn(client);

		clientDAO.rechercherClientParId(1L);

		verify(em).find(Client.class, 1L);
	}

	@Test
	public void testRechercherTousLesClients() throws BanqueException {
		List<Client> listeClients = new ArrayList<Client>(1);
		when(em.createNamedQuery("tous.les.clients")).thenReturn(query);
		when(query.getResultList()).thenReturn(listeClients);

		clientDAO.rechercherTousLesClients();

		verify(query).getResultList();
	}

	@Test
	public void testRechercherClientsParNomEtPrenom() throws BanqueException {
		List<Client> listeClients = new ArrayList<Client>(1);
		when(em.createNamedQuery("clients.par.nom.et.prenom")).thenReturn(query);
		when(query.setParameter("leNom", "DUPONT")).thenReturn(query);
		when(query.setParameter("lePrenom", "Robert")).thenReturn(query);
		when(query.getResultList()).thenReturn(listeClients);

		clientDAO.rechercherClientsParNomEtPrenom("DUPONT", "Robert");

		verify(query).getResultList();
	}

	@Test
	public void testModifierClient() throws BanqueException {
		Client client = new Client();
		client.setId(1);
		client.setNom("DUPONT");
		client.setPrenom("Robert");
		client.setAdresse("40 rue de la Paix");
		client.setCodePostal("75007");
		client.setVille("Paris");
		client.setMotDePasse("secret");

		clientDAO.modifierClient(client);

		verify(em).merge(client);
	}

}
