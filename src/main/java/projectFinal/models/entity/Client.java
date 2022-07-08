package projectFinal.models.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Getter @Setter
public class Client extends Utilisateur{

    private String email;
    private LocalDate dateNaissance;

    @OneToMany(mappedBy = "client_id")
    private List<Commande> commandes;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority("ROLE_USER"),
                new SimpleGrantedAuthority("READ")
        );
    }
}
