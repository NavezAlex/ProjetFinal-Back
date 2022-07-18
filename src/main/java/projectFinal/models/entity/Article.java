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
    private double prix;
    private boolean actif;
    private int stock;

    private String pictureUrl;

    @ManyToOne
    private Categorie categorie;

    @ManyToOne
    private Fournisseur fournisseur;


//    public Article() {
//    }

    public Article(String name, String description, double prix, boolean actif, int stock, String pictureUrl, Categorie categorie, Fournisseur fournisseur) {
        this.name = name;
        this.description = description;
        this.prix = prix;
        this.actif = actif;
        this.stock = stock;
        this.pictureUrl = pictureUrl;
        this.categorie = categorie;
        this.fournisseur = fournisseur;

    }
}
