package projectarchi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectarchi.dto.ExamDTO;
import projectarchi.model.Exam;
import projectarchi.service.ExamService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/exams")
public class ExamController {
    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    // Endpoint DTO pour obtenir une vue synthétique des examens
    @GetMapping("/dto")
    public ResponseEntity<List<ExamDTO>> getAllExamDTOs() {
        return ResponseEntity.ok(examService.getAllExamDTOs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable Long id) {
        Optional<Exam> exam = examService.getExamById(id);
        return exam.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam) {
        Exam savedExam = examService.saveExam(exam);
        return ResponseEntity.ok(savedExam);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exam> updateExam(@PathVariable Long id, @RequestBody Exam updatedExam) {
        Optional<Exam> examOptional = examService.getExamById(id);
        if (examOptional.isPresent()) {
            Exam exam = examOptional.get();
            exam.setExamTitle(updatedExam.getExamTitle());
            exam.setCourse(updatedExam.getCourse());
            exam.setTeacher(updatedExam.getTeacher());
            exam.setQuestions(updatedExam.getQuestions());
            exam.setExamStudents(updatedExam.getExamStudents());
            return ResponseEntity.ok(examService.saveExam(exam));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
        return ResponseEntity.noContent().build();
    }
}
