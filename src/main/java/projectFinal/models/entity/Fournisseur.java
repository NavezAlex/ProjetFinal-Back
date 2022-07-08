package projectFinal.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;
    private String adresse;
    private long telephone;

    @OneToMany(mappedBy = "fournisseur")
    private List<Article> articles;

    public Fournisseur(String nom, String adresse, long telephone) {
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
    }
}
