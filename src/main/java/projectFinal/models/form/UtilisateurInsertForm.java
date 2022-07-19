package projectFinal.models.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UtilisateurInsertForm {

    @NotEmpty
    private String username;

    @Length(min = 5, message = "*Votre mot de passe est trop court")
    @NotEmpty
    private String password;

}
