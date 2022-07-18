package projectFinal.service;

import org.springframework.stereotype.Service;
import projectFinal.models.dto.ArticleDTO;
import projectFinal.models.entity.Article;
import projectFinal.models.entity.Categorie;
import projectFinal.models.form.ArticleForm;
import projectFinal.models.form.ArticleUpdateForm;

import java.util.List;

@Service
public interface ArticleService {

    List<ArticleDTO> getAll();
    ArticleDTO getOne(long id);

    long insert(ArticleForm form);
    void update(long id, ArticleUpdateForm form);

    List<ArticleDTO> getArticleByCategory(int category);

    List<ArticleDTO> getArticleByFournisseur(int fournisseur);

}
