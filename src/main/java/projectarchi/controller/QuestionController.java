package projectarchi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectarchi.dto.QuestionDTO;
import projectarchi.model.Question;
import projectarchi.service.QuestionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // Endpoint DTO pour obtenir une vue synthétique des questions
    @GetMapping("/dto")
    public ResponseEntity<List<QuestionDTO>> getAllQuestionDTOs() {
        return ResponseEntity.ok(questionService.getAllQuestionDTOs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Optional<Question> question = questionService.getQuestionById(id);
        return question.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        Question savedQuestion = questionService.saveQuestion(question);
        return ResponseEntity.ok(savedQuestion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question updatedQuestion) {
        Optional<Question> questionOptional = questionService.getQuestionById(id);
        if (questionOptional.isPresent()) {
            Question question = questionOptional.get();
            question.setCategory(updatedQuestion.getCategory());
            question.setDifficultyLevel(updatedQuestion.getDifficultyLevel());
            question.setOption1(updatedQuestion.getOption1());
            question.setOption2(updatedQuestion.getOption2());
            question.setOption3(updatedQuestion.getOption3());
            question.setOption4(updatedQuestion.getOption4());
            question.setQuestionTitle(updatedQuestion.getQuestionTitle());
            question.setRightAnswer(updatedQuestion.getRightAnswer());
            question.setExam(updatedQuestion.getExam());
            return ResponseEntity.ok(questionService.saveQuestion(question));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }
}
