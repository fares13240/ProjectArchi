package projectarchi.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public List<Exam> getAllExams() {
        return examService.getAllExams();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable Long id) {
        Optional<Exam> exam = examService.getExamById(id);
        return exam.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Exam createExam(@RequestBody Exam exam) {
        return examService.saveExam(exam);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exam> updateExam(@PathVariable Long id, @RequestBody Exam updatedExam) {
        Optional<Exam> examOptional = examService.getExamById(id);
        if (examOptional.isPresent()) {
            Exam exam = examOptional.get();
            exam.setExamTitle(updatedExam.getExamTitle());
            exam.setCourse(updatedExam.getCourse());
            exam.setTeacher(updatedExam.getTeacher());
            // Pour les questions, selon ta logique, tu pourras aussi gérer leur mise à jour
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
