package projectFinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projectFinal.models.dto.ArticleDTO;
import projectFinal.models.form.ArticleUpdateForm;
import projectFinal.service.ArticleService;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService ;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

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

    @GetMapping("/{id}/update")
    public String updateForm(
            @PathVariable @ModelAttribute long id,
            @ModelAttribute("article") ArticleUpdateForm form
    ){
        ArticleDTO dto = articleService.getOne(id);

        form.setNom(dto.getName());
        form.setDescription(dto.getDescription());
        form.setPrix(dto.getPrix());
        form.setStock(dto.getStock());

        return "article/update";
    }

    @PostMapping("/{id}/update")
    public String processUpdate(@PathVariable long id, @ModelAttribute("hotel")ArticleUpdateForm form){
        articleService.update(id, form);
        return "redirect:/article/"+id+"/details";
    }


}