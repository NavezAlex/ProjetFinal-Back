package projectFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectFinal.models.entity.CommandeDetail;

public interface CommandeDetailRepository extends JpaRepository<CommandeDetail, Long> {
}
