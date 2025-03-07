package projectarchi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectarchi.model.Course;
import projectarchi.model.Exam;
import projectarchi.model.User;
import projectarchi.service.CourseService;
import projectarchi.service.ExamService;
import projectarchi.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;
    private final UserService userService;
    private final ExamService examService;



    public CourseController(CourseService courseService, UserService userService, ExamService examService) {
        this.courseService = courseService;
        this.userService = userService;
        this.examService = examService;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Optional<Course> course = courseService.getCourseById(id);
        return course.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
        Optional<Course> courseOptional = courseService.getCourseById(id);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            course.setTitle(updatedCourse.getTitle());
            course.setExams(updatedCourse.getExams());
            course.setStudents(updatedCourse.getStudents());
            return ResponseEntity.ok(courseService.saveCourse(course));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{courseId}/students/{studentId}")
    public ResponseEntity<Course> addStudentToCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        Optional<Course> courseOptional = courseService.getCourseById(courseId);
        Optional<User> studentOptional = userService.getUserById(studentId);

        if (courseOptional.isPresent() && studentOptional.isPresent()) {
            Course course = courseOptional.get();
            User student = studentOptional.get();

            // Ajouter l'étudiant au cours
            course.getStudents().add(student);
            // Mettre à jour la relation bidirectionnelle
            student.getCourses().add(course);

            // Inscription automatique aux examens du cours
            if (course.getExams() != null) {
                for (Exam exam : course.getExams()) {
                    exam.getExamStudents().add(student);
                    // Mettre à jour la relation bidirectionnelle
                    student.getExams().add(exam);
                    // Sauvegarde ou mise à jour de l'examen (optionnel si cascade bien configuré)
                    examService.saveExam(exam);
                }
            }

            courseService.saveCourse(course); // La table course_students sera mise à jour
            return ResponseEntity.ok(course);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}