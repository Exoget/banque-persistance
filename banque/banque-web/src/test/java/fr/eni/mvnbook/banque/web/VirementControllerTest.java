package fr.eni.mvnbook.banque.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;

import fr.eni.mvnbook.banque.metier.BanqueService;
import fr.eni.mvnbook.banque.persistance.entity.Client;
import fr.eni.mvnbook.banque.persistance.entity.Compte;
import fr.eni.mvnbook.banque.persistance.util.BanqueException;

public class VirementControllerTest extends TestController {

	@Mock
	private BanqueService banqueService;
	
	@Mock
	private ModelMap model;
	
	@InjectMocks
	private VirementController virementController;

	private Client client;
	private List<Compte> listeDesComptes;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		client = getTestClient();
		listeDesComptes = getTestListeDesComptes(client);
	}

	@Test
	public void testShowForm() throws BanqueException {
		when(banqueService.mesComptes(client.getId())).thenReturn(listeDesComptes);
		
		String resultat = virementController.showForm(client, model);
		
		verify(banqueService).mesComptes(client.getId());
		verify(model).addAttribute("lesComptes", listeDesComptes);
		
		assertThat(resultat).isEqualTo("virement");
	}

	@Test
	public void testInitForm() {
		assertThat(virementController.initForm()).isNotNull().isInstanceOf(VirementForm.class);
	}

	@Test
	public void testSubmitForm() throws BanqueException {
		VirementForm virementForm = new VirementForm();
		virementForm.setDebiter("245646786");
		virementForm.setCrediter("263434345");
		virementForm.setMontant("100");
		
		when(banqueService.mesComptes(1L)).thenReturn(listeDesComptes);
		
		String result = virementController.submitForm(virementForm, client, model);
		
		verify(banqueService).virement(245646786, 263434345, 100);
		verify(banqueService).mesComptes(client.getId());
		verify(model).addAttribute("lesComptes", listeDesComptes);
		
		assertEquals("comptes", result);
	}

}
