package projectFinal.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import projectFinal.models.entity.Categorie;
import projectFinal.models.entity.Fournisseur;

@Data
@AllArgsConstructor
public class ArticleDTO {

    private long id;
    private String name;
    private String description;
    private double prix;
    private boolean actif;
    private int stock;
    private String pictureUrl;
    private Categorie categorie;
    private Fournisseur fournisseur;

    public ArticleDTO() {

    }

}
