package projectFinal.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleDTO {

    private long id;
    private String nom;
    private String description;
    private float prix;
    private boolean actif;
    private int stock;

    private FournisseurDTO fournisseur;
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
