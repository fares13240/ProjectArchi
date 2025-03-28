package projectarchi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectarchi.dto.CourseDTO;
import projectarchi.model.Course;
import projectarchi.model.Exam;
import projectarchi.model.User;
import projectarchi.service.CourseService;
import projectarchi.service.ExamService;
import projectarchi.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;
    private final ExamService examService;
    private final UserService userService;

    public CourseController(CourseService courseService, ExamService examService, UserService userService) {
        this.courseService = courseService;
        this.examService = examService;
        this.userService = userService;
    }

    // Endpoint pour obtenir une vue synthétique de tous les cours (DTO)
    @GetMapping("/dto")
    public ResponseEntity<List<CourseDTO>> getAllCourseDTOs() {
        return ResponseEntity.ok(courseService.getAllCourseDTOs());
    }

    // Endpoint pour obtenir un cours par ID sous forme de DTO
    @GetMapping("/{id}/dto")
    public ResponseEntity<CourseDTO> getCourseDTOById(@PathVariable Long id) {
        Optional<Course> courseOpt = courseService.getCourseById(id);
        return courseOpt.map(course -> ResponseEntity.ok(courseService.convertToDTO(course)))
                .orElse(ResponseEntity.notFound().build());
    }


    // Endpoint classique pour obtenir l'entité Course (attention à la récursivité)
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Optional<Course> course = courseService.getCourseById(id);
        return course.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course savedCourse = courseService.saveCourse(course);
        return ResponseEntity.ok(savedCourse);
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

    @PatchMapping("/{id}/title")
    public ResponseEntity<Course> updateCourseTitle(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        Optional<Course> courseOptional = courseService.getCourseById(id);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            if (updates.containsKey("title")) {
                course.setTitle(updates.get("title"));
            }
            return ResponseEntity.ok(courseService.saveCourse(course));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/exams")
    public ResponseEntity<Course> updateCourseExams(@PathVariable Long id, @RequestBody List<Long> examIds) {
        Optional<Course> courseOptional = courseService.getCourseById(id);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            Set<Exam> exams = examIds.stream()
                    .map(examService::getExamById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toSet());
            course.setExams(exams);
            return ResponseEntity.ok(courseService.saveCourse(course));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/students")
    public ResponseEntity<Course> updateCourseStudents(@PathVariable Long id, @RequestBody List<Long> studentIds) {
        Optional<Course> courseOptional = courseService.getCourseById(id);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            Set<User> students = studentIds.stream()
                    .map(userService::getUserById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toSet());
            course.setStudents(students);
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

    // Endpoint pour afficher la liste des étudiants inscrits et non inscrits pour un cours donné
    @GetMapping("/{id}/students/status")
    public ResponseEntity<Map<String, List<User>>> getStudentsStatusForCourse(@PathVariable Long id) {
        Optional<Course> courseOptional = courseService.getCourseById(id);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            List<User> enrolled = course.getStudents().stream().collect(Collectors.toList());
            List<User> allStudents = userService.getAllStudents();
            List<User> notEnrolled = allStudents.stream()
                    .filter(student -> !course.getStudents().contains(student))
                    .collect(Collectors.toList());
            Map<String, List<User>> response = Map.of("enrolled", enrolled, "notEnrolled", notEnrolled);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{courseId}/students/{studentId}")
    public ResponseEntity<Course> addStudentToCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        Optional<Course> courseOptional = courseService.getCourseById(courseId);
        Optional<User> studentOptional = userService.getUserById(studentId);

        if (courseOptional.isPresent() && studentOptional.isPresent()) {
            Course course = courseOptional.get();
            User student = studentOptional.get();

            if (course.getStudents().contains(student)) {
                return ResponseEntity.badRequest().build();
            }

            course.getStudents().add(student);
            student.getCourses().add(course);

            if (course.getExams() != null) {
                for (Exam exam : course.getExams()) {
                    exam.getExamStudents().add(student);
                    student.getExams().add(exam);
                    examService.saveExam(exam);
                }
            }

            Course savedCourse = courseService.saveCourse(course);
            return ResponseEntity.ok(savedCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{courseId}/students/{studentId}")
    public ResponseEntity<Course> removeStudentFromCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        Optional<Course> courseOptional = courseService.getCourseById(courseId);
        Optional<User> studentOptional = userService.getUserById(studentId);

        if (courseOptional.isPresent() && studentOptional.isPresent()) {
            Course course = courseOptional.get();
            User student = studentOptional.get();

            if (!course.getStudents().contains(student)) {
                return ResponseEntity.badRequest().build();
            }

            course.getStudents().remove(student);
            student.getCourses().remove(course);

            if (course.getExams() != null) {
                for (Exam exam : course.getExams()) {
                    exam.getExamStudents().remove(student);
                    student.getExams().remove(exam);
                    examService.saveExam(exam);
                }
            }

            Course savedCourse = courseService.saveCourse(course);
            return ResponseEntity.ok(savedCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
