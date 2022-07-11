package projectFinal.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import projectFinal.models.entity.Fournisseur;

@Data
@AllArgsConstructor
public class ArticleDTO {

    private long id;
    private String name;
    private String description;
    private float prix;
    private boolean actif;
    private int stock;

    private FournisseurDTO fournisseur;

    public ArticleDTO() {

    }

    @Data
    public class FournisseurDTO{
        private String nom;
        private String adresse;
        private long telephone;
    }

    private CategorieDTO categorie;
    @Data
    public class CategorieDTO{
        private String nom;
        private String description;
    }

}
