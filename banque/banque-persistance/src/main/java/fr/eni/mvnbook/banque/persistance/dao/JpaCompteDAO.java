package fr.eni.mvnbook.banque.persistance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import fr.eni.mvnbook.banque.persistance.entity.Client;
import fr.eni.mvnbook.banque.persistance.entity.Compte;
import fr.eni.mvnbook.banque.persistance.util.BanqueException;

@Component(value = "compteDAO")
public class JpaCompteDAO implements CompteDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void ajouterCompte(Compte compte) throws BanqueException {
		try {
			em.merge(compte);
		} 
		catch (Exception e) {
			throw new BanqueException("Erreur d'ajout du compte.");
		}
	}

	public Compte rechercherCompteParNumero(long numero) throws BanqueException {
		return em.find(Compte.class, numero);
	}

	@SuppressWarnings("unchecked")
	public List<Compte> rechercherComptesClient(Client client) throws BanqueException {
		try {
			Query query = em.createNamedQuery("rechercher.comptes.client");
			query.setParameter("leClient", client);
			return query.getResultList();
				
		} 
		catch (Exception e) {
			throw new BanqueException("Erreur de récupération des comptes.");
		}
	}

	public void modifierCompte(Compte compte) throws BanqueException {
		try {
			em.merge(compte);
		}
		catch (Exception e) {
			throw new BanqueException("Erreur de modification du compte.");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> rechercherComptesDebiteurs() throws BanqueException {
		try {
			Query query = em.createNamedQuery("rechercher.comptes.debiteurs");
			return query.getResultList();
				
		} 
		catch (Exception e) {
			throw new BanqueException("Erreur de récupération des comptes.");
		}
	}

	@Override
	public void supprimerCompte(Compte compte) throws BanqueException {
		try {
			em.remove(compte);
		}
		catch (Exception e) {
			throw new BanqueException("Erreur de suppresion du compte.");
		}
	}

}
