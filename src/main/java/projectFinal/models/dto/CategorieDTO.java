package projectFinal.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategorieDTO {

    private long id;
    private String nom;
    private String description;
    private List<ArticleDTO> articles;

}
