package projectFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projectFinal.models.entity.Article;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findByName(String name);

    @Query(value = "SELECT * FROM article a WHERE a.categorie_id = :cate", nativeQuery = true)
    List<Article> findArticleByCategorie(@Param(value = "cate") int cate);

    @Query(value = "SELECT * FROM article a WHERE a.fournisseur_id = :fournisseur", nativeQuery = true)
    List<Article> findArticleByFournisseur(@Param(value = "fournisseur") int fournisseur);

}
