package fr.eni.mvnbook.banque.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.mvnbook.banque.metier.BanqueService;
import fr.eni.mvnbook.banque.persistance.entity.Client;
import fr.eni.mvnbook.banque.persistance.entity.Compte;

@Controller
@SessionAttributes({"leClient"})
public class IdentificationController {

	@Inject
	private BanqueService banqueService;
	
	@RequestMapping(value="/identification.do", method=RequestMethod.GET)
	public String showForm() {
		return "identification";
	}
	
	@ModelAttribute("identificationForm")
	public IdentificationForm initForm() {
		IdentificationForm form = new IdentificationForm();
		return form;
	}
	
	@RequestMapping(value="/identification.do", method=RequestMethod.POST)
	public String submitForm(
		@ModelAttribute("identificationForm") IdentificationForm form,
		ModelMap model
	) {
		try {
			Client client = banqueService.authentifier(
				Long.parseLong(form.getIdentifiant()),
				form.getMotDePasse()
			);
			List<Compte> listeComptes = banqueService.mesComptes(client.getId());
			model.addAttribute("leClient", client);
			model.addAttribute("lesComptes", listeComptes);
			return "comptes";
		} 
		catch(Exception e) {
			e.printStackTrace();
			String message = e.getMessage();
			model.addAttribute("message", message);
			return "identification";
		}
	}
}





