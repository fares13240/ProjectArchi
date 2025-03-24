package projectarchi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectarchi.model.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);
}
