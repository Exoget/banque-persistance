package fr.eni.mvnbook.banque.web;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IdentificationFormTest {

	private IdentificationForm identificationForm;
	
	@Before
	public void setUp() throws Exception {
		identificationForm = new IdentificationForm();
		identificationForm.setIdentifiant("1");
		identificationForm.setMotDePasse("secret");
	}

	@Test
	public void testGetIdentifiant() {
		assertEquals("1", identificationForm.getIdentifiant());
	}

	@Test
	public void testSetIdentifiant() {
		identificationForm.setIdentifiant("99");
		assertEquals("99", identificationForm.getIdentifiant());
	}

	@Test
	public void testGetMotDePasse() {
		assertEquals("secret", identificationForm.getMotDePasse());
	}

	@Test
	public void testSetMotDePasse() {
		identificationForm.setMotDePasse("Pa$$w0rd");
		assertEquals("Pa$$w0rd", identificationForm.getMotDePasse());
	}

}
