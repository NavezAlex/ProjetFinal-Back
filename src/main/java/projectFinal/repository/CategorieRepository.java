package projectFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectFinal.models.entity.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    Categorie findByName(String name);
}
