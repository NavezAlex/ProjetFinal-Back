package projectFinal.models.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommandeDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "article_id", referencedColumnName = "article_id")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "commande_id", referencedColumnName = "commande_id")
    private Commande commande;

    private int quantite;

    private float totalPrice;

    private boolean isDeleted;

}
