package projectFinal.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Article_Commande {

    @ManyToOne
    private Article id_article;

    @ManyToOne
    private Commande id_commande;

    private int quantite;
}
