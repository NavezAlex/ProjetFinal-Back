package projectFinal.models.form;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import projectFinal.models.entity.Client;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class ClientInsertForm {

    @NotBlank
    @Size(min = 5, max = 20)
    private String username;
    @NotBlank @Size(min = 10)
    private String password;
    @NotBlank @Email
    private String email;
    @NotNull
    @Past
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateNaissance;

    public Client toEntity(){
        Client c = new Client();
        c.setUsername(username);
        c.setPassword(password);
        c.setDateNaissance(dateNaissance);
        c.setEmail(email);
        return c;
    }

}
