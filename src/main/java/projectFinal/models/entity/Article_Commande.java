package projectFinal.models.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Article_Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Article article;

    @ManyToOne
    private Commande commande;

    private int quantite;

}
