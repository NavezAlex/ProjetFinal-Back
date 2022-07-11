package projectFinal.service;

import org.springframework.stereotype.Service;
import projectFinal.mapper.ArticleMapper;
import projectFinal.models.dto.ArticleDTO;
import projectFinal.models.entity.Article;
import projectFinal.models.form.ArticleForm;
import projectFinal.models.form.ArticleUpdateForm;
import projectFinal.repository.ArticleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    //@Autowired
    private final ArticleRepository repository;
    private final ArticleMapper mapper;

    public ArticleServiceImpl(ArticleRepository repository, ArticleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ArticleDTO> getAll() {
        return repository.findAll().stream()
                .map( mapper::toDto )
                .toList();
    }

    @Override
    public ArticleDTO getOne(long id) {
        return repository.findById(id)
                .map( mapper::toDto )
                .orElseThrow();
    }

    @Override
    public long insert(ArticleForm form) {
        Article entity = mapper.toEntity( form );
        entity = repository.save( entity );
        return entity.getId();
    }

    @Override
    public void update(long id, ArticleUpdateForm form) {
        Article article = repository.findById(id)
                .orElseThrow();

        article.setName( form.getNom() );
        article.setDescription(form.getDescription());
        article.setPrix(form.getPrix());
        article.setStock(form.getStock());

        repository.save(article);
    }

    @Override
    public List<ArticleDTO> getArticleByCategory(int category){
        return repository.findArticleByCategorie(category)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleDTO> getArticleByFournisseur(int fournisseur){
        return repository.findArticleByFournisseur(fournisseur)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

}
