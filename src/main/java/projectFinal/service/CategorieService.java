package projectFinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectFinal.models.entity.Categorie;
import projectFinal.repository.CategorieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public List<Categorie> listCategories(){
        return categorieRepository.findAll();
    }

    public Categorie findByName(String name){ return categorieRepository.findByName(name); }

    public void createCategorie(Categorie categorie){
        categorieRepository.save(categorie);
    }

    public Categorie get(long id){
        return categorieRepository.findById(id).get();
    }

    public Optional<Categorie> readCategory(long categoryId) {
        return categorieRepository.findById(categoryId);
    }

    public void updateCategory(long categoryID, Categorie newCategory) {
        Categorie category = categorieRepository.findById(categoryID).get();
        category.setName(newCategory.getName());
        category.setDescription(newCategory.getDescription());
        categorieRepository.save(category);
    }

    public void delete(long id){
        categorieRepository.deleteById(id);
    }

    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }
}
