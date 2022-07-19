package projectFinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectFinal.models.entity.PanierDetail;
import projectFinal.repository.PanierDetailRepository;

import java.util.List;

@Service
public class PanierDetailService {

    @Autowired
    private PanierDetailRepository repository;

    public List<PanierDetail> findAll(){
        return repository.findAll();
    }

    public void save(PanierDetail order){
        repository.save(order);
    }

    public PanierDetail get(long id){
        return repository.findById(id).get();
    }

    public void delete(long id){
        repository.deleteById(id);
    }

}
