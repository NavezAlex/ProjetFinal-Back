package projectFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectFinal.models.entity.AuthenticationToken;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Long> {
}
