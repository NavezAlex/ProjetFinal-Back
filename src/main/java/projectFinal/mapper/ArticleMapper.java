package projectFinal.mapper;

import org.springframework.stereotype.Service;
import projectFinal.models.dto.ArticleDTO;
import projectFinal.models.entity.Article;
import projectFinal.models.form.ArticleForm;

@Service
public class ArticleMapper {

    public ArticleDTO toDto(Article entity){
        if(entity == null) return null;

        ArticleDTO dto = new ArticleDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPrix(entity.getPrix());
        dto.setActif(entity.isActif());
        dto.setStock(entity.getStock());

        dto.setCategorie(entity.getCategorie());
        dto.setFournisseur(entity.getFournisseur());

        return dto;
    }

    public Article toEntity(ArticleForm form) {
        if (form == null) return null;

        return new Article(
                form.getName(),
                form.getDescription(),
                form.getPrix(),
                form.isActif(),
                form.getStock(),
                form.getPicture(),
                form.getId_categorie(),
                form.getId_fournisseur()
        );
    }

}
