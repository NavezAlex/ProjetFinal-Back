package projectFinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectFinal.models.entity.*;
import projectFinal.repository.CommandeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private final CommandeRepository repository;

    public CommandeService(CommandeRepository repository) {
        this.repository = repository;
    }

    public List<Commande> findAllCommandes(Client client){
        return client.getCommandes();
    }

    public Commande get(long id){
        return repository.findById(id).get();
    }

    public void delete(long id){
        repository.deleteById(id);
    }

    public Commande saveOrder(Panier panier){

        Commande commande = new Commande();
        commande.setClient(panier.getClient());
        commande.setOrderDate(new Date());
        commande.setSous_total(panier.getSous_total());
        commande.setTaxRate(panier.getTaxRate());
        commande.setTax_total(panier.getTax_total());
        commande.setPrix_total(panier.getPrix_total());

        List<CommandeDetail> commandeDetailList = new ArrayList<>();
        for (PanierDetail panierDetail : panier.getPanierDetailList()){
            CommandeDetail commandeDetail = new CommandeDetail();

            commandeDetail.setCommande(commande);
            commandeDetail.setArticle(panierDetail.getArticle());
            commandeDetail.setQuantite(panierDetail.getQuantite());
            commandeDetail.setTotalPrice(panierDetail.getTotalPrice());
            commandeDetail.setDeleted(false);

            commandeDetailList.add(commandeDetail);
        }
        commande.setCommandeDetailList(commandeDetailList);
        repository.save(commande);

        return commande;
    }

}
