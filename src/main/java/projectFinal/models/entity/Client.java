package projectFinal.models.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Getter @Setter
public class Client extends Utilisateur{

    @Email
    @Column(unique = true)
    private String email;
    private LocalDate dateNaissance;

    @OneToMany(mappedBy = "client")
    private List<Commande> commandes;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority("ROLE_USER"),
                new SimpleGrantedAuthority("READ")
        );
    }

    @Override
    public String toString() {
        return "Client{" +
                "email='" + email + '\'' +
                ", dateNaissance=" + dateNaissance + '\'' +
                //", commandes=" + commandes +
                '}';
    }
}
