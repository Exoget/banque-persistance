package fr.eni.mvnbook.banque.web;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class IndexControllerTest {

	@InjectMocks
	private IndexController indexController;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAccueil() {
		assertEquals("accueil", indexController.accueil());
	}

}
