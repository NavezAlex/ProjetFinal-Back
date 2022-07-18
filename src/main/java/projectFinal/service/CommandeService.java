package projectFinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectFinal.models.entity.Article;
import projectFinal.models.entity.Commande;
import projectFinal.repository.CommandeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandeService {

    @Autowired
    private final CommandeRepository repository;

    public CommandeService(CommandeRepository repository) {
        this.repository = repository;
    }

    public List<Commande> findCommandeByClient(int clientId){
        return new ArrayList<>(repository.findCommandeByClient(clientId));
    }

}
