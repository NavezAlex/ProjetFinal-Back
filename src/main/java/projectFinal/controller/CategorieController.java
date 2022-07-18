package projectFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectFinal.models.entity.Categorie;
import projectFinal.service.CategorieService;

import java.util.List;


@RestController
@RequestMapping("/categorie")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/")
    public ResponseEntity<List<Categorie>> getCategories(){
        List<Categorie> body = categorieService.listCategories();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping("/create")
    public String createCategorie(@RequestBody Categorie categorie){
        categorieService.createCategorie(categorie);
        return "Catégorie créée";
    }

}
