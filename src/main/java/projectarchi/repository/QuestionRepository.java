package projectarchi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectarchi.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
