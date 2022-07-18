package projectFinal.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_commande;

    private LocalDate date;
    private boolean isComplet;
    private boolean isAnnul = false;

    private double prix_total;

    @ManyToOne
    private Client client;

//    @ManyToMany
//    private List<Article> articles;



}
