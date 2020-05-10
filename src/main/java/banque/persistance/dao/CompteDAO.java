package banque.persistance.dao;

import banque.persistance.entity.Client;
import banque.persistance.entity.Compte;
import banque.persistance.util.BanqueException;

import java.util.List;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

public interface CompteDAO {

    @Transactional(value = TxType.REQUIRED, rollbackOn = BanqueException.class)
    void ajouterCompte(Compte compte) throws BanqueException;

    @Transactional(value = TxType.SUPPORTS, rollbackOn = BanqueException.class)
    Compte rechercherCompteParNumero(long numero) throws BanqueException;

    @Transactional(value = TxType.SUPPORTS, rollbackOn = BanqueException.class)
    List<Compte> rechercherComptesClient(Client client) throws BanqueException;

    @Transactional(value = TxType.SUPPORTS, rollbackOn = BanqueException.class)
    List<Compte> rechercherComptesDebiteurs() throws BanqueException;

    @Transactional(value = TxType.REQUIRED, rollbackOn = BanqueException.class)
    void modifierCompte(Compte compte) throws BanqueException;

    @Transactional(value = TxType.REQUIRED, rollbackOn = BanqueException.class)
    void supprimerCompte(Compte compte) throws BanqueException;

}