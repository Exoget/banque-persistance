package banque.persistance.entity;


import org.junit.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.*;

public class ClientTest {
    private Client client;
    private static Validator validator;

    @BeforeClass
    public static void setUpBeforeClass() {
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
        client.setNom("FERCHICHI");
        client.setPrenom("Fares");
        client.setAdresse("40 rue de la Paix");
        client.setCodePostal("92000");
        client.setVille("Nanterre");
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
    public void testCodePostalErrone() {

        client.setCodePostal("440000");
        assertEquals("440000", client.getCodePostal());

        Set<ConstraintViolation<Client>> violations = validator.validate(client);
        assertFalse(violations.isEmpty());

        assertEquals(1, violations.size());
        assertEquals(
                "Le code postal est erroné.",
                violations.iterator().next().getMessage()
        );
    }
}