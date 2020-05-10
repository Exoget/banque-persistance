package banque.persistance.dao;

import banque.persistance.entity.Client;
import banque.persistance.util.BanqueException;

import java.util.List;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;


public interface ClientDAO {

    @Transactional(value = TxType.REQUIRED, rollbackOn = BanqueException.class)
    void ajouterClient(Client client) throws BanqueException;

    @Transactional(value = TxType.SUPPORTS, rollbackOn = BanqueException.class)
    Client rechercherClientParId(long id) throws BanqueException;

    @Transactional(value = TxType.SUPPORTS, rollbackOn = BanqueException.class)
    List<Client> rechercherTousLesClients() throws BanqueException;

    @Transactional(value = TxType.SUPPORTS, rollbackOn = BanqueException.class)
    List<Client> rechercherClientsParNomEtPrenom(String nom, String prenom) throws BanqueException;

    @Transactional(value = TxType.REQUIRED, rollbackOn = BanqueException.class)
    void modifierClient(Client client) throws BanqueException;

    @Transactional(value = TxType.REQUIRED, rollbackOn = BanqueException.class)
    void supprimerClient(Client client) throws BanqueException;

}