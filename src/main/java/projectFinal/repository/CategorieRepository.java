package projectFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectFinal.models.entity.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
