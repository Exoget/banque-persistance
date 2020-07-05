package fr.eni.mvnbook.banque.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.SAXException;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;

import fr.eni.mvnbook.banque.config.ConfigurationMetier;
import fr.eni.mvnbook.banque.config.ConfigurationPersistance;

public class IdentificationControllerIT {

	private static final String APP_URL = "http://tomcat.elanglet.local/banque-web";

	@Test
	public void testIdentificationController() throws IOException, SAXException {
		WebConversation wc = new WebConversation();
		WebResponse response = wc.getResponse(APP_URL + "/identification.do");
		WebForm identificationForm = response.getForms()[0];
		identificationForm.setParameter("identifiant", "1");
		identificationForm.setParameter("motDePasse", "password");
		WebResponse submitResponse = identificationForm.submit();
		assertThat(submitResponse.getText()).contains("Robert");
		assertThat(submitResponse.getText()).contains("DUPONT");
		assertThat(submitResponse.getText()).contains("245646786");
		assertThat(submitResponse.getText()).contains("263434345");
	}

}
