package projectarchi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectarchi.dto.QuizDTO;
import projectarchi.model.Quiz;
import projectarchi.service.QuizService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    // Endpoint DTO pour obtenir une vue synthétique des quiz
    @GetMapping("/dto")
    public ResponseEntity<List<QuizDTO>> getAllQuizDTOs() {
        return ResponseEntity.ok(quizService.getAllQuizDTOs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long id) {
        Optional<Quiz> quiz = quizService.getQuizById(id);
        return quiz.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        Quiz savedQuiz = quizService.saveQuiz(quiz);
        return ResponseEntity.ok(savedQuiz);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable Long id, @RequestBody Quiz updatedQuiz) {
        Optional<Quiz> quizOptional = quizService.getQuizById(id);
        if (quizOptional.isPresent()) {
            Quiz quiz = quizOptional.get();
            quiz.setTitle(updatedQuiz.getTitle());
            quiz.setQuestions(updatedQuiz.getQuestions());
            return ResponseEntity.ok(quizService.saveQuiz(quiz));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
        return ResponseEntity.noContent().build();
    }
}
