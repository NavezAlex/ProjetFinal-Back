package projectFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectFinal.models.entity.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
}
