package projectFinal.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import projectFinal.models.entity.*;
import projectFinal.repository.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Component
public class DataInit implements InitializingBean {

    private final CategorieRepository categorieRepository;
    private final FournisseurRepository fournisseurRepository;
    private final AdminRepository adminRepository;
    private final ClientRepository clientRepository;
    private final ArticleRepository articleRepository;

    private final PasswordEncoder passwordEncoder;

    public DataInit(CategorieRepository categorieRepository, FournisseurRepository fournisseurRepository, AdminRepository adminRepository, ClientRepository clientRepository, ArticleRepository articleRepository, PasswordEncoder passwordEncoder) {
        this.categorieRepository = categorieRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.adminRepository = adminRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

//        Admin admin = new Admin();
//        admin.setId(1);
//        admin.setUsername( "admin" );
//        admin.setPassword( passwordEncoder.encode("admin") );
//        admin.setRef( UUID.randomUUID() );
//        adminRepository.save(admin);
//
//        Client user = new Client();
//        user.setId(2);
//        user.setUsername("user");
//        user.setPassword(passwordEncoder.encode("pass"));
//        user.setEmail("user1.client@client.com");
//        user.setDateNaissance(LocalDate.of(1993,03,03));
//        clientRepository.save(user);
//
//
//        List<Fournisseur> toInsert = List.of(
//                new Fournisseur("Fourni1", "rue du Premier", 111111111),
//                new Fournisseur("Fourni-2", "rue du Deuxieme", 222222222),
//                new Fournisseur("Fourni 3", "rue du Troisieme", 333333333)
//        );
//        fournisseurRepository.saveAll(toInsert);
//
//        List<Categorie> toPlace = List.of(
//                new Categorie("Livre", "Ceci est un livre"),
//                new Categorie("Carte", "Ceci est des cartes"),
//                new Categorie("Dé", "Ceci est un dé"),
//                new Categorie("Jeu Société", "Ceci est un jeu de société"),
//                new Categorie("Jeu Vidéo", "Ceci est un jeu vidéo")
//        );
//        categorieRepository.saveAll(toPlace);


//        List<Article> articlesToInsert = List.of(
//                new Article(1,"Set de Dé","",2,true,100,fournisseurRepository.getReferenceById(1L), categorieRepository.getReferenceById(3L)),
//                new Article("Livre 1 Actif","",10,true,50,fournisseurRepository.getReferenceById(2L), categorieRepository.getReferenceById(1L)),
//                new Article("Livre 2 Inactif","",10,false,50,fournisseurRepository.getReferenceById(2L), categorieRepository.getReferenceById(1L)),
//                new Article("Carte avec Stock","",5,true,25,fournisseurRepository.getReferenceById(3L), categorieRepository.getReferenceById(2L)),
//                new Article("Carte sans Stock","",5,true,0,fournisseurRepository.getReferenceById(3L), categorieRepository.getReferenceById(2L))
//        );
//        articleRepository.saveAll(articlesToInsert);

    }


}
