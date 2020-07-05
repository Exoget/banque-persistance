package fr.eni.mvnbook.banque.metier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.eni.mvnbook.banque.persistance.dao.ClientDAO;
import fr.eni.mvnbook.banque.persistance.dao.CompteDAO;
import fr.eni.mvnbook.banque.persistance.entity.Client;
import fr.eni.mvnbook.banque.persistance.entity.Compte;
import fr.eni.mvnbook.banque.persistance.util.BanqueException;

public class BanqueServiceImplTest {

	@Mock
	private CompteDAO compteDAO;
	
	@Mock
	private ClientDAO clientDAO;
	
	@InjectMocks
	private BanqueServiceImpl banqueService;
	
	private Client client;
	private Compte compte1;
	private Compte compte2;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		client = new Client();
		client.setId(1);
		client.setNom("DUPONT");
		client.setPrenom("Robert");
		client.setAdresse("40 rue de la Paix");
		client.setCodePostal("75007");	
		client.setVille("Paris");
		client.setMotDePasse("secret");	
		
		compte1 = new Compte(12563, 5000.00, client);
		compte2 = new Compte(985632, 444.00, client);
	}
	
	@Test
	public void testAuthentifier() {
		try {
				
			when(clientDAO.rechercherClientParId(1L)).thenReturn(client);
		
			Client authClient = banqueService.authentifier(1L, "secret");
			assertEquals(client.getId(), authClient.getId());
			assertEquals(client.getPrenom(), authClient.getPrenom());
			assertEquals(client.getNom(), authClient.getNom());
			assertEquals(client.getAdresse(), authClient.getAdresse());
			assertEquals(client.getCodePostal(), authClient.getCodePostal());
			assertEquals(client.getVille(), authClient.getVille());
			assertEquals(client.getMotDePasse(), authClient.getMotDePasse());
						
			verify(clientDAO).rechercherClientParId(1L);
		}
		catch (BanqueException e) {
			fail(e.getMessage());
		}
	}
	
	@Test(expected = BanqueException.class)
	public void testAuthentifierFail() throws BanqueException {
		
		when(clientDAO.rechercherClientParId(2L)).thenThrow(BanqueException.class);
						
		banqueService.authentifier(2L, "secret");
		
		verify(clientDAO).rechercherClientParId(2L);
	}

	@Test
	public void testMesComptes() {
		try {
			List<Compte> listeDesComptes = new ArrayList<Compte>();
			listeDesComptes.add(compte1);
			listeDesComptes.add(compte2);
			
			when(compteDAO.rechercherComptesClient(client)).thenReturn(listeDesComptes);
		
			banqueService.mesComptes(client.getId());
			
			Client leClient = verify(clientDAO).rechercherClientParId(client.getId());
			verify(compteDAO).rechercherComptesClient(leClient);
		} 
		catch (BanqueException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testVirement() {
		try {
			when(compteDAO.rechercherCompteParNumero(12563)).thenReturn(compte1);
			when(compteDAO.rechercherCompteParNumero(985632)).thenReturn(compte2);

			banqueService.virement(12563, 985632, 100);
			
			verify(compteDAO).rechercherCompteParNumero(12563);
			verify(compteDAO).rechercherCompteParNumero(985632);
			verify(compteDAO).modifierCompte(compte1);
			verify(compteDAO).modifierCompte(compte2);
			
			assertEquals(new Double(4900.00), new Double(compte1.getSolde()));
			assertEquals(new Double(544.00), new Double(compte2.getSolde()));
		} 
		catch (BanqueException e) {
			fail(e.getMessage());
		}
	}

}
