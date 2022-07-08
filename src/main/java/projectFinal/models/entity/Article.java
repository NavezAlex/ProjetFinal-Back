package projectFinal.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@AllArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;
    private String description;
    private float prix;
    private boolean actif;
    private int stock;

    @ManyToOne
    private Fournisseur fournisseur;


    @ManyToOne
    private Categorie categorie;

    public Article() {
    }

    public Article(String nom, String description, float prix, boolean actif, int stock) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.actif = actif;
        this.stock = stock;
    }
}
