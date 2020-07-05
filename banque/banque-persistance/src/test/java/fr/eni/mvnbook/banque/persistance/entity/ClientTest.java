package fr.eni.mvnbook.banque.persistance.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClientTest {

	private Client client;
	
	private static Validator validator;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		client = new Client();
		client.setId(12);
		client.setNom("DUPONT");
		client.setPrenom("Robert");
		client.setAdresse("40 rue de la Paix");
		client.setCodePostal("75007");	
		client.setVille("Paris");
		client.setMotDePasse("secret");	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testClient() {
		client = new Client();
		assertNotNull(client);
	}

	@Test
	public void testEqualsObject() {
		Client client2 = new Client();
		client2.setId(12);
		client2.setNom("DUPONT");
		client2.setPrenom("Robert");
		client2.setAdresse("40 rue de la Paix");
		client2.setCodePostal("75007");	
		client2.setVille("Paris");
		client2.setMotDePasse("secret");
		
		assertEquals(client, client2);
	}
	
	@Test
	public void testNonEqualsObject() {
		Client client2 = new Client();
		client2.setId(85);
		client2.setNom("DUPONT");
		client2.setPrenom("Robert");
		client2.setAdresse("40 rue de la Paix");
		client2.setCodePostal("75007");	
		client2.setVille("Paris");
		client2.setMotDePasse("secret");
		assertNotEquals(client, client2);
	}

	@Test
	public void testGetId() {
		assertEquals(12, client.getId());
	}

	@Test
	public void testSetId() {
		client.setId(85);
		assertEquals(85, client.getId());
	}

	@Test
	public void testGetNom() {
		assertEquals("DUPONT", client.getNom());
	}

	@Test
	public void testSetNom() {
		client.setNom("DURAND");
		assertEquals("DURAND", client.getNom());

	}

	@Test
	public void testGetPrenom() {
		assertEquals("Robert", client.getPrenom());
	}

	@Test
	public void testSetPrenom() {
		client.setPrenom("Michel");
		assertEquals("Michel", client.getPrenom());
	}

	@Test
	public void testGetAdresse() {
		assertEquals("40 rue de la Paix", client.getAdresse());
	}

	@Test
	public void testSetAdresse() {
		client.setAdresse("222 rue Du Tertre");
		assertEquals("222 rue Du Tertre", client.getAdresse());
	}

	@Test
	public void testGetCodePostal() {
		assertEquals("75007", client.getCodePostal());
	}

	@Test
	public void testSetCodePostal() {
		client.setCodePostal("44000");
		assertEquals("44000", client.getCodePostal());
	}

	@Test
	public void testSetCodePostalErrone() {
		client.setCodePostal("440000");
		assertEquals("440000", client.getCodePostal());
		Set<ConstraintViolation<Client>> violations = validator.validate(client);
		assertFalse(violations.isEmpty());
	}
	
	@Test
	public void testGetVille() {
		assertEquals("Paris", client.getVille());
	}

	@Test
	public void testSetVille() {
		client.setVille("Nantes");
		assertEquals("Nantes", client.getVille());
	}

	@Test
	public void testGetMotDePasse() {
		assertEquals("secret", client.getMotDePasse());
	}

	@Test
	public void testSetMotDePasse() {
		client.setMotDePasse("123456");
		assertEquals("123456", client.getMotDePasse());
	}

}
