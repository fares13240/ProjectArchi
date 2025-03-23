package projectarchi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectarchi.model.Quiz;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findByQuestions_Id(Long questionId);
}
