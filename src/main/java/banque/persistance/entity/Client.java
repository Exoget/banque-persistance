package banque.persistance.entity;


import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Client {

    @NotNull
    private long id;

    @NotBlank
    @Size(max = 100)
    private String nom;

    @NotBlank
    @Size(max = 50)
    private String prenom;

    @NotBlank
    @Size(max = 200)
    private String adresse;

    @NotBlank
    @Size(max = 5)
    @Pattern(regexp = "[0-9]{5}")
    private String codePostal;

    @NotBlank
    @Size(max = 200)
    private String ville;

    @NotBlank
    @Size(max = 100)
    private String motDePasse;
}