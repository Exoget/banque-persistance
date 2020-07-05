package fr.eni.mvnbook.banque.metier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.eni.mvnbook.banque.config.ConfigurationMetier;
import fr.eni.mvnbook.banque.config.ConfigurationPersistanceIntegration;
import fr.eni.mvnbook.banque.persistance.entity.Client;
import fr.eni.mvnbook.banque.persistance.entity.Compte;
import fr.eni.mvnbook.banque.persistance.util.BanqueException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigurationPersistanceIntegration.class, ConfigurationMetier.class})
@Transactional
public class BanqueServiceImplIT {

	@Inject
	private BanqueService banqueService;
	
	@Test
	public void testAuthentifier() throws BanqueException {
		Client client = banqueService.authentifier(1L, "password");

		assertEquals(1, client.getId());
		assertEquals("DUPONT", client.getNom());
		assertEquals("Robert", client.getPrenom());
		assertEquals("40 rue de la Paix", client.getAdresse());
		assertEquals("75000", client.getCodePostal());
		assertEquals("Paris", client.getVille());
		assertEquals("password", client.getMotDePasse());
	}
	
	@Test(expected = BanqueException.class)
	public void testAuthentifierEchec() throws BanqueException {
		banqueService.authentifier(1L, "pa$$word");
	}

	@Test
	public void testMesComptes() throws BanqueException {
		List<Compte> listeDesComptes = banqueService.mesComptes(1);
		
		assertThat(listeDesComptes).isNotNull().hasSize(2);
		assertThat(listeDesComptes).extracting(p -> p.getNumero()).containsExactlyInAnyOrder(245646786L, 263434345L);
		assertThat(listeDesComptes).extracting (p -> p.getSolde()).containsExactlyInAnyOrder(20000.0, 8400.0);
	}

	@Test
	public void testVirement() throws BanqueException {
		banqueService.virement(245646786L, 263434345L, 100);
		
		List<Compte> listeDesComptes = banqueService.mesComptes(1);
		assertThat(listeDesComptes).isNotNull().hasSize(2);
		assertThat(listeDesComptes).extracting (p -> p.getSolde()).containsExactlyInAnyOrder(20100.0, 8300.0);	
	}

}
