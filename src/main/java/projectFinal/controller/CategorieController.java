package projectFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projectFinal.models.entity.Categorie;
import projectFinal.service.CategorieService;

import java.util.List;


@Controller
@RequestMapping("/categorie")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/")
    public ResponseEntity<List<Categorie>> getCategories(){
        List<Categorie> body = categorieService.listCategories();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("/add")
    public String addCategorie(Categorie categorie, Model model){
        model.addAttribute("categorie", categorie);
        return "/categorie/add-edit-category";
    }

    @GetMapping("/edit/{id}")
    public String editCategorie(@PathVariable("id") int id, Model model){
        Categorie categorie = categorieService.get(id);
        model.addAttribute("categorie", categorie);

        return "/categorie/add-edit-category";
    }

    @PostMapping("/create")
    public String createCategorie(@RequestBody Categorie categorie){
        categorieService.createCategorie(categorie);
        return "redirect:/categorie/list?success";
    }

    @GetMapping("/list")
    public String listCategorie(Model model){
        List<Categorie> listCategories = categorieService.findAll();
        model.addAttribute("listCategories", listCategories);

        return "/categorie/list-category";
    }

}
