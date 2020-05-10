package banque.persistance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import banque.persistance.entity.Client;
import banque.persistance.util.BanqueException;
import org.springframework.stereotype.Component;



@Component(value = "clientDAO")
public class JpaClientDAO implements ClientDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void ajouterClient(Client client) throws BanqueException {
        try {
            em.persist(client);
        }
        catch (Exception e) {
            throw new BanqueException("Erreur d'ajout du client.");
        }
    }

    @Override
    public Client rechercherClientParId(long id) throws BanqueException {
        try {
            return em.find(Client.class, id);
        }
        catch (Exception e) {
            throw new BanqueException("Erreur de chargement du client.");
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Client> rechercherTousLesClients() throws BanqueException {
        try {
            Query query = em.createNamedQuery("tous.les.clients");
            return query.getResultList();
        }
        catch (Exception e) {
            throw new BanqueException("Erreur de chargement des clients.");
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Client> rechercherClientsParNomEtPrenom(String nom, String prenom) throws BanqueException {
        try {
            Query query = em.createNamedQuery("clients.par.nom.et.prenom");
            query.setParameter("leNom", nom);
            query.setParameter("lePrenom", prenom);
            return query.getResultList();
        }
        catch (Exception e) {
            throw new BanqueException("Erreur de chargement des clients.");
        }
    }

    @Override
    public void modifierClient(Client client) throws BanqueException {
        try {
            em.merge(client);
        }
        catch (Exception e) {
            throw new BanqueException("Erreur de modification du client.");
        }
    }

    @Override
    public void supprimerClient(Client client) throws BanqueException {
        try {
            em.remove(client);
        }
        catch (Exception e) {
            throw new BanqueException("Erreur de suppression du client.");
        }
    }

}