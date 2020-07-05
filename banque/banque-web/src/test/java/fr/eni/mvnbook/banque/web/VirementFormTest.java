package fr.eni.mvnbook.banque.web;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class VirementFormTest {

	private VirementForm virementForm;
	
	@Before
	public void setUp() throws Exception {
		virementForm = new VirementForm();
		virementForm.setCrediter("898985");
		virementForm.setDebiter("236589");
		virementForm.setMontant("2365.02");
	}

	@Test
	public void testGetDebiter() {
		assertEquals("236589", virementForm.getDebiter());
	}

	@Test
	public void testSetDebiter() {
		virementForm.setDebiter("222222");
		assertEquals("222222", virementForm.getDebiter());
	}

	@Test
	public void testGetCrediter() {
		assertEquals("898985", virementForm.getCrediter());
	}

	@Test
	public void testSetCrediter() {
		virementForm.setCrediter("111111");
		assertEquals("111111", virementForm.getCrediter());
	}

	@Test
	public void testGetMontant() {
		assertEquals("2365.02", virementForm.getMontant());
	}

	@Test
	public void testSetMontant() {
		virementForm.setMontant("333333");
		assertEquals("333333", virementForm.getMontant());
	}

}
