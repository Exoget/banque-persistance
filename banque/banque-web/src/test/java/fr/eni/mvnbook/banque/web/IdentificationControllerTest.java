package fr.eni.mvnbook.banque.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

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

public class IdentificationControllerTest extends TestController {

	@Mock
	private BanqueService banqueService;
	
	@Mock
	private ModelMap model;
	
	@InjectMocks
	private IdentificationController identifcationController;
	
	private IdentificationForm identificationForm;
	private Client client;
	private List<Compte> listeDesComptes;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		identificationForm = new IdentificationForm();
		identificationForm.setIdentifiant("1");
		identificationForm.setMotDePasse("secret");
		
		client = getTestClient();
		listeDesComptes = getTestListeDesComptes(client);
	}

	@Test
	public void testShowForm() {
		assertEquals("identification", identifcationController.showForm());
	}

	@Test
	public void testInitForm() {
		assertNotNull(identifcationController.initForm());
	}

	@Test
	public void testSubmitForm() throws BanqueException {
		
		when(banqueService.authentifier(1L, "secret")).thenReturn(client);
		when(banqueService.mesComptes(1L)).thenReturn(listeDesComptes);
		
		String result = identifcationController.submitForm(identificationForm, model);
		
		verify(banqueService).authentifier(1L, "secret");
		verify(banqueService).mesComptes(1L);
		verify(model).addAttribute("leClient", client);
		verify(model).addAttribute("lesComptes", listeDesComptes);
		
		assertEquals("comptes", result);	
	}

}
