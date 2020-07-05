package banque.persistance.entity;


import javax.persistence.*;

//JPA 2 identifie les objets qui vont être persistés
@Entity
@Table(name = "compte")
@NamedQueries({
        @NamedQuery(
                name = "rechercher.comptes.client",
                query = "from Compte as c where c.client=:leClient"
        ),
        @NamedQuery(
                name = "rechercher.comptes.debiteurs",
                query = "from Compte as c where c.solde < 0"
        )
})
public class Compte {

    @Id
    @Column(name = "numero")
    private long numero;

    @Column(name = "solde", precision = 10, scale = 2)
    private double solde;

    //Les relations entre ces entités sont gérées par des méta-données définies à partir
    // d’annotations directement dans la classe ou de fichiers XML externes
    @ManyToOne(targetEntity = Client.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idclient")
    private Client client;
}