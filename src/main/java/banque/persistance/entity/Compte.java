package banque.persistance.entity;


import javax.persistence.*;

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

    @ManyToOne(targetEntity = Client.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idclient")
    private Client client;
}
