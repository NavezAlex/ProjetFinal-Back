package projectFinal.models.dto;

import lombok.Builder;
import lombok.Data;
import projectFinal.models.entity.Client;

import java.time.LocalDate;

@Data
@Builder
public class ClientDTO {

    private long id;
    private String username;
    private String email;
    private String password;
    private LocalDate dateNaissance;

    public static ClientDTO of(Client entity){
        if(entity == null)
            return null;

        return ClientDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .dateNaissance(entity.getDateNaissance())
                .build();
    }

}
