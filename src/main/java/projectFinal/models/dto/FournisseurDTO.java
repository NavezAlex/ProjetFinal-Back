package projectFinal.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FournisseurDTO {

    private long id;
    private String nom;
    private String adresse;
    private long telephone;

    private List<ArticleDTO> articles;

    public FournisseurDTO() {
    }
}
