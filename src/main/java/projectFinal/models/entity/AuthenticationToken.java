package projectFinal.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String token;

    private Date createdDate;

    @OneToOne(targetEntity = Utilisateur.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "id")
    private Utilisateur utilisateur;

    public String getToken(){
        return token;
    }

}
