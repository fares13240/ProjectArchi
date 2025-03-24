package projectarchi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectarchi.model.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
