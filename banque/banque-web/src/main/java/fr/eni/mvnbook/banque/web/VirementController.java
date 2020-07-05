package fr.eni.mvnbook.banque.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.mvnbook.banque.metier.BanqueService;
import fr.eni.mvnbook.banque.persistance.entity.Client;
import fr.eni.mvnbook.banque.persistance.entity.Compte;
import fr.eni.mvnbook.banque.persistance.util.BanqueException;

@Controller
@SessionAttributes({"leClient"})
public class VirementController {

	@Inject
	private BanqueService banqueService;

	@RequestMapping(value="/virement.do", method=RequestMethod.GET)
	public String showForm(@ModelAttribute("leClient") Client client, ModelMap model) {
		try {
			List<Compte> listeComptes = banqueService.mesComptes(client.getId());
		
			model.addAttribute("lesComptes", listeComptes);
			
			return "virement";
		} 
		catch (BanqueException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@ModelAttribute("virementForm")
	public VirementForm initForm() {
		return new VirementForm();
	}
	
	@RequestMapping(
			value="/virement.do", method=RequestMethod.POST
	)
	public String submitForm(
		@ModelAttribute("virementForm") VirementForm virementForm, 
		@ModelAttribute("leClient") Client client, 
		ModelMap model
	) {
		try {
			banqueService.virement(
				Long.parseLong(virementForm.getDebiter()), 
				Long.parseLong(virementForm.getCrediter()), 
				Double.parseDouble(virementForm.getMontant())
			);
			
			List<Compte> listeDeComptes = banqueService.mesComptes(client.getId());
			model.addAttribute("lesComptes", listeDeComptes);
			return "comptes";
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
