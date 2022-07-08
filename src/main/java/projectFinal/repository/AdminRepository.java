package projectFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectFinal.models.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
