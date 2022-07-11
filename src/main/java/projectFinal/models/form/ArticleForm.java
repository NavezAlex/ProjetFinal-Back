package projectFinal.models.form;

import lombok.Data;
import projectFinal.models.entity.Article;

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

    public Article toEntity(){
        Article entity = new Article();
        entity.setName(name);
        entity.setDescription(description);
        entity.setPrix(prix);
        return  entity;
    }


}
