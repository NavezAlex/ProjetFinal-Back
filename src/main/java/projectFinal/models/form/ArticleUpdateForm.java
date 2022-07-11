package projectFinal.models.form;

import lombok.Data;

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
    private float prix = 0.0F;

    @AssertTrue
    private boolean actif;

    @PositiveOrZero
    private int stock;
}
