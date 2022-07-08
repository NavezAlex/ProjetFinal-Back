package projectFinal.mapper;

import org.springframework.stereotype.Service;
import projectFinal.models.dto.FournisseurDTO;
import projectFinal.models.entity.Fournisseur;

@Service
public class FournisseurMapper {

    private final ArticleMapper aMapper;

    public FournisseurMapper(ArticleMapper aMapper){ this.aMapper = aMapper;}

    public FournisseurDTO toDto(Fournisseur entity){
        if(entity == null) return null;

        return new FournisseurDTO(
                entity.getId(),
                entity.getNom(),
                entity.getAdresse(),
                entity.getTelephone(),
                entity.getArticles().stream()
                        .map( aMapper::toDto)
                        .toList()
        );
    }



}
