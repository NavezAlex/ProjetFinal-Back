package projectFinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectFinal.models.entity.CommandeDetail;
import projectFinal.repository.CommandeDetailRepository;

import java.util.List;

@Service
public class CommandeDetailService {

    @Autowired
    private CommandeDetailRepository repository;

    public List<CommandeDetail> findAll() {
        return repository.findAll();
    }

    public void save(CommandeDetail commande){
        repository.save(commande);
    }

    public CommandeDetail get(long id){
        return repository.findById(id).get();
    }

    public void delete(long id){
        repository.deleteById(id);
    }

}
