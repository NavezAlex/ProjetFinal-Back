package projectFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectFinal.models.entity.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
