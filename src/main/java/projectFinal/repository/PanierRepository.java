package projectFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectFinal.models.entity.Panier;

public interface PanierRepository extends JpaRepository<Panier, Long> {
}
