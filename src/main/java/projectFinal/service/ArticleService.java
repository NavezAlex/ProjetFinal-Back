package projectFinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectFinal.mapper.ArticleMapper;
import projectFinal.models.dto.ArticleDTO;
import projectFinal.models.form.ArticleForm;
import projectFinal.models.form.ArticleUpdateForm;
import projectFinal.repository.ArticleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public interface ArticleService {

    List<ArticleDTO> getAll();
    ArticleDTO getOne(long id);

    long insert(ArticleForm form);
    void update(long id, ArticleUpdateForm form);

    List<ArticleDTO> getArticleByCategory(int category);

    List<ArticleDTO> getArticleByFournisseur(int fournisseur);
}
