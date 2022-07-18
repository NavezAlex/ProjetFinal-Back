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

    public void createCategorie(Categorie categorie){
        categorieRepository.save(categorie);
    }

    public Optional<Categorie> readCategory(long categoryId) {
        return categorieRepository.findById(categoryId);
    }

    public void updateCategory(long categoryID, Categorie newCategory) {
        Categorie category = categorieRepository.findById(categoryID).get();
        category.setNom(newCategory.getNom());
        category.setDescription(newCategory.getDescription());
        categorieRepository.save(category);
    }

}
