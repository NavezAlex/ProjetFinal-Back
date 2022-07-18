package projectFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projectFinal.models.entity.Commande;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {

    @Query(value = "SELECT * FROM commande c WHERE c.client_id = :client", nativeQuery = true)
    List<Commande> findCommandeByClient(@Param(value = "client") int client);

//    @Query(value = "SELECT * FROM article_commande ac WHERE ac.client_id = :client", nativeQuery = true)
//    List<Article_Commande> findArtCommande(@Param(value = "id_comm") int id_comm);

}
