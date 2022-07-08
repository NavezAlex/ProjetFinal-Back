package projectFinal.models.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CommandeDTO {

    private long id;
    private LocalDate date;
    private boolean isComplet;
    private boolean isAnnul;

    private ClientDTO client_id;

    @Data
    public class ClientDTO{

        private long id;
        private String username;
        private String email;
        private LocalDate dateNaissance;
    }

}
