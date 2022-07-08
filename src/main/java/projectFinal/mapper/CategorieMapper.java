package projectFinal.mapper;

import org.springframework.stereotype.Service;
import projectFinal.models.dto.CategorieDTO;
import projectFinal.models.entity.Categorie;

@Service
public class CategorieMapper {

    private final ArticleMapper aMapper;

    public CategorieMapper(ArticleMapper aMapper){ this.aMapper = aMapper;}

    public CategorieDTO toDto(Categorie entity){
        if (entity == null) return null;

        return new CategorieDTO(
                entity.getId(),
                entity.getNom(),
                entity.getDescription(),
                entity.getArticles().stream()
                        .map( aMapper::toDto)
                        .toList()
        );
    }

}
