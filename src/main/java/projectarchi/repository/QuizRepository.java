package projectarchi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectarchi.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
