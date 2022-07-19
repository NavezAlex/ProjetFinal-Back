package projectFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import projectFinal.models.entity.Client;
import projectFinal.models.entity.Panier;
import projectFinal.service.*;

import java.security.Principal;

@Controller
public class PanierController {

    @Autowired
    ArticleService articleService;
    @Autowired
    ClientService clientService;
    @Autowired
    PanierService panierService;
    @Autowired
    CommandeService commandeService;

    @RequestMapping("/vue-panier")
    public String vuePanier(Model model, Principal principal){
        Client client = clientService.findByUsername(principal.getName());
        Panier panier = client.getPanier();

        return "/vue-panier";
    }

}
