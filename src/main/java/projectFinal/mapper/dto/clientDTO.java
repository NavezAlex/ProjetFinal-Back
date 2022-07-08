package projectFinal.mapper.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class clientDTO {

    private long id;
    private String email;
    private String password;
    private LocalDate dateNaissance;
    private boolean isAdmin;

}
