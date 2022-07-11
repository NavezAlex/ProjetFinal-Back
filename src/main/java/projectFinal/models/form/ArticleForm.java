package projectFinal.models.form;

import lombok.Data;
import projectFinal.models.entity.Article;
import projectFinal.models.entity.Categorie;
import projectFinal.models.entity.Fournisseur;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
public class ArticleForm {

    @NotBlank
    private String name;

    private String description;

    @Positive
    private float prix;

    @AssertTrue
    private boolean actif;

    @PositiveOrZero
    private int stock;

    @Positive
    private Fournisseur id_fournisseur;

    @Positive
    private Categorie id_categorie;

    public Article toEntity(){
        Article entity = new Article();
        entity.setName(name);
        entity.setDescription(description);
        entity.setPrix(prix);
        entity.setActif(actif);
        entity.setStock(stock);
        entity.setCategorie(id_categorie);
        entity.setFournisseur(id_fournisseur);
        return  entity;
    }

}
