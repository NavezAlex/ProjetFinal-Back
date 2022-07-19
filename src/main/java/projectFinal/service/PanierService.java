package projectFinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectFinal.models.entity.Article;
import projectFinal.models.entity.Client;
import projectFinal.models.entity.Panier;
import projectFinal.models.entity.PanierDetail;
import projectFinal.repository.PanierDetailRepository;
import projectFinal.repository.PanierRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PanierService {

    @Autowired
    private PanierRepository panierRepository;

    @Autowired
    private PanierDetailRepository panierDetailRepository;

    private float TAX_RATE = 5.0F;

    public Panier findById(long idPanier){
        return  panierRepository.findById(idPanier).get();
    }

    private PanierDetail findPanierDetail(Panier panier, long articleId){

        for (PanierDetail panierDetail : panier.getPanierDetailList()){
            if(panierDetail.getArticle().getId() == articleId){
                return panierDetail;
            }
        }
        return null;
    }

    private float getSousTotal(Panier panier){
        float sous_Total = 0.0F;

        for (PanierDetail panierDetail : panier.getPanierDetailList()){
            sous_Total += panierDetail.getTotalPrice();
        }
        return sous_Total;
    }

    public Panier findPanier(Client client){
        if (client.getPanier() == null){
            Panier panier = new Panier();
            panier.setClient(client);
            panier.setPanierDetailList(new ArrayList<>());
            return panier;
        }
        return client.getPanier();
    }

    public Panier addtoPanier(Article article, int quantity, Client client){
        float sous_total = 0.0F, totalPrice = 0.0F, tax_total = 0.0F, prix_total = 0.0F;
        int totalQuantite = 0;

        Panier panier = findPanier(client);
        PanierDetail panierDetail = findPanierDetail(panier, article.getId());

        if(panierDetail == null){
            panierDetail = new PanierDetail();
            panierDetail.setArticle(article);
            panierDetail.setPanier(panier);

            List<PanierDetail> panierDetailList = panier.getPanierDetailList();
            panierDetailList.add(panierDetail);

            panier.setPanierDetailList(panierDetailList);
        }

        article.setStock( article.getStock()-quantity );

        totalQuantite = panierDetail.getQuantite() + quantity;
        panierDetail.setQuantite(totalQuantite);

        totalPrice = article.getPrix() * totalQuantite;
        panierDetail.setTotalPrice(totalPrice);

        sous_total = getSousTotal(panier);
        panier.setSous_total(sous_total);

        panier.setTaxRate(TAX_RATE);

        tax_total = (TAX_RATE / 100) * sous_total;
        panier.setTax_total(tax_total);

        prix_total = sous_total + tax_total;
        panier.setPrix_total(prix_total);

        panierRepository.save(panier);

        return panier;
    }


    public Panier removeFromPanier(Article article, int quantity, Client client){
        float sous_total = 0.0F, totalPrice = 0.0F, tax_total = 0.0F, prix_total = 0.0F;
        int totalQuantite = 0;

        Panier panier = findPanier(client);
        PanierDetail panierDetail = findPanierDetail(panier, article.getId());

        List<PanierDetail> panierDetailList = panier.getPanierDetailList();

        panierDetailList.remove(panierDetail);
        panier.setPanierDetailList(panierDetailList);


        sous_total = getSousTotal(panier);
        panier.setSous_total(sous_total);

        panier.setTaxRate(TAX_RATE);

        tax_total = (TAX_RATE / 100) * sous_total;
        panier.setTax_total(tax_total);

        prix_total = sous_total + tax_total;
        panier.setPrix_total(prix_total);

        panierRepository.save(panier);

        panierDetailRepository.delete(panierDetail);

        return panier;
    }

    public Panier updatePanier(Article article, int quantity, Client client){
        float sous_total = 0.0F, totalPrice = 0.0F, tax_total = 0.0F, prix_total = 0.0F;
        int totalQuantite = 0;

        Panier panier = findPanier(client);
        PanierDetail panierDetail = findPanierDetail(panier, article.getId());

        List<PanierDetail> panierDetailList = panier.getPanierDetailList();

        panierDetailList.remove(panierDetail);
        panier.setPanierDetailList(panierDetailList);

        totalQuantite = panierDetail.getQuantite() + quantity;
        panierDetail.setQuantite(totalQuantite);

        totalPrice = article.getPrix() * totalQuantite;
        panierDetail.setTotalPrice(totalPrice);

        sous_total = getSousTotal(panier);
        panier.setSous_total(sous_total);

        panier.setTaxRate(TAX_RATE);

        tax_total = (TAX_RATE / 100) * sous_total;
        panier.setTax_total(tax_total);

        prix_total = sous_total + tax_total;
        panier.setPrix_total(prix_total);

        panierRepository.save(panier);

        return panier;
    }

    public void emptyPanier(Client client){
        if (client == null || client.getPanier() == null) return;

        panierRepository.delete(client.getPanier());
    }

}
