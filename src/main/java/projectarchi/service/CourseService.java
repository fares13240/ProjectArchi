package projectarchi.service;

import org.springframework.stereotype.Service;
import projectarchi.dto.CourseDTO;
import projectarchi.model.Course;
import projectarchi.repository.CourseRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    // Méthode de conversion en DTO
    public CourseDTO convertToDTO(Course course) {
        int examCount = course.getExams() != null ? course.getExams().size() : 0;
        int enrolledCount = course.getStudents() != null ? course.getStudents().size() : 0;
        // Adaptation : si course possède description et creationDate, sinon mettre null
        return new CourseDTO(
                course.getId(),
                course.getTitle(),
                null,          // description
                null,          // creationDate
                examCount,
                enrolledCount
        );
    }

    public List<CourseDTO> getAllCourseDTOs() {
        return getAllCourses().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
