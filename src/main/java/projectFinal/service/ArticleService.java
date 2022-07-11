package projectFinal.service;


import projectFinal.models.dto.ArticleDTO;
import projectFinal.models.form.ArticleForm;
import projectFinal.models.form.ArticleUpdateForm;
import projectFinal.repository.ArticleRepository;

import java.util.List;

public interface ArticleService {

    List<ArticleDTO> getAll();
    ArticleDTO getOne(long id);

    long insert(ArticleForm form);
    void update(long id, ArticleUpdateForm form);

}
