package projectFinal.models.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class CommandeDTO {

    private long id;
    private Date date;
    private boolean isComplet;
    private boolean isAnnul;

    private ClientDTO client_id;

    //private List<ArticleDTO> articles_list;

//    @Data
//    public class ClientDTO{
//
//        private long id;
//        private String username;
//        private String email;
//        private LocalDate dateNaissance;
//    }

}
