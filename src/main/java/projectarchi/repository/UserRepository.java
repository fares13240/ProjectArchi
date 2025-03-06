package projectarchi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectarchi.model.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    // Exemple de méthode custom : recherche par nom d'utilisateur
    List<User> findByUsername(String username);
}
