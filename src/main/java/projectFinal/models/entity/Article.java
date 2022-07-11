package projectFinal.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private float prix;
    private boolean actif;
    private int stock;

    @ManyToOne
    private Fournisseur fournisseur;


    @ManyToOne
    private Categorie categorie;

//    public Article() {
//    }

    public Article(String name, String description, float prix, boolean actif, int stock, Fournisseur fournisseur, Categorie categorie) {
        this.name = name;
        this.description = description;
        this.prix = prix;
        this.actif = actif;
        this.stock = stock;
        this.fournisseur = fournisseur;
        this.categorie = categorie;
    }
}
