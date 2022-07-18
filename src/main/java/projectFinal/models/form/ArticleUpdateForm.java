package projectFinal.models.form;

import lombok.Data;
import projectFinal.models.entity.Categorie;
import projectFinal.models.entity.Fournisseur;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
public class ArticleUpdateForm {
    @NotBlank
    private String nom;

    private String description;

    @Positive
    private double prix = 0.0F;

    @AssertTrue
    private boolean actif;

    @PositiveOrZero
    private int stock;

    @Positive
    private Categorie id_categorie;

    @Positive
    private Fournisseur id_fournisseur;

}
