package projectFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectFinal.models.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
