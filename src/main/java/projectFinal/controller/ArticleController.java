package projectFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import projectFinal.models.dto.ArticleDTO;
import projectFinal.models.entity.Article;
import projectFinal.models.entity.Categorie;
import projectFinal.models.form.ArticleForm;
import projectFinal.models.form.ArticleUpdateForm;
import projectFinal.service.ArticleService;
import projectFinal.service.CategorieService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    CategorieService categorieService;


//    @GetMapping("/all")
//    public String displayAll(Model model){
//        List<ArticleDTO> articles = articleService.getAll();
//        model.addAttribute("articles", articles);
//    }

    @GetMapping("/all")
    public String displayAll(Model model){
        List<ArticleDTO> articles = articleService.getAll();
        model.addAttribute("articles", articles);
        return "article/displayAll";
    }

    @GetMapping("/{id:[0-9]+}/details")
    public String displayOne( @PathVariable long id, Model model ){
        model.addAttribute("article", articleService.getOne(id));
        return "article/displayOne";
    }

    @GetMapping("/add")
    public String createForm( @ModelAttribute("article") ArticleForm form ){
        return "article/insert";
    }

    @PostMapping("/add")
    public String processCreate(@Valid @ModelAttribute("article") ArticleForm form, BindingResult binding){

        if( binding.hasErrors() )
            return "article/insert";

        long id = articleService.insert(form);
        return "redirect:/article/"+id+"/details";
    }

    @GetMapping("/edit/{id}")
    public String updateForm(
            @PathVariable @ModelAttribute long id,
            @ModelAttribute("article") ArticleUpdateForm form
    ){
        ArticleDTO dto = articleService.getOne(id);

        form.setNom(dto.getName());
        form.setDescription(dto.getDescription());
        form.setPrix(dto.getPrix());
        form.setStock(dto.getStock());
        form.setId_categorie(dto.getCategorie());

        return "article/update";
    }

    @PostMapping("/edit/{id}")
    public String processUpdate(@PathVariable long id, @ModelAttribute("article")ArticleUpdateForm form){
        articleService.update(id, form);
        return "redirect:/article/"+id+"/details";
    }

    @GetMapping("/list")
    public String listArticle(Model model){
        List<Categorie> categories = categorieService.findAll();
        model.addAttribute("categories", categories);

        List<Article> listArticles = articleService.findAllByActive();
        model.addAttribute("listArticles", listArticles);
        return "/article/list-article";
    }

    @GetMapping("/categorie/{cate}")
    public String displayCate( @PathVariable int cate ){
        List<ArticleDTO> articles = articleService.getArticleByCategory(cate);
        return "article/displayCate";
    }

    @GetMapping("/fournisseur/{fournisseur}")
    public String displayFourn( @PathVariable int fournisseur ){
        List<ArticleDTO> articles = articleService.getArticleByFournisseur(fournisseur);
        return "article/displayFourn";
    }

}
