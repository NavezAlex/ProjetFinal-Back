package projectFinal.models.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FournisseurForm {

    @NotBlank
    private String nom;
    @NotBlank
    private String adresse;
    private long telephone;
}
