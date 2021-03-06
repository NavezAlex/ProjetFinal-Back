package projectFinal.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commande_id")
    private long id;

    private Date orderDate;
    private boolean isComplet;
    private boolean isAnnul = false;

    private float sous_total;
    private float taxRate;
    private float tax_total;
    private float prix_total;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private Client client;

//    @ManyToMany
//    private List<Article> articles;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commande")
    private List<CommandeDetail> commandeDetailList;


}
