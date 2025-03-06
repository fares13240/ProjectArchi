package projectarchi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectarchi.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
