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
    @Column(name = "article_id")
    private long id;

    private String name;
    private String description;
    private float prix;
    private boolean actif;
    private int stock;

    private String pictureUrl;

    @ManyToOne
    private Categorie categorie;

    @ManyToOne
    private Fournisseur fournisseur;


//    public Article() {
//    }

    public Article(String name, String description, float prix, boolean actif, int stock, String pictureUrl, Categorie categorie, Fournisseur fournisseur) {
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
