package projectFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectFinal.models.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
