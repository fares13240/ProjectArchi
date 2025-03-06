package projectarchi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectarchi.model.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    // Exemple custom : trouver le premier examen d'un enseignant
    // @Query("SELECT e FROM Exam e WHERE e.teacher.username = :username ORDER BY e.id ASC")
    // Exam findFirstByTeacherUsername(@Param("username") String username);
}
