package projectarchi.service;

import org.springframework.stereotype.Service;
import projectarchi.dto.QuestionDTO;
import projectarchi.dto.QuizSummaryDTO;
import projectarchi.model.Question;
import projectarchi.model.Quiz;
import projectarchi.repository.QuestionRepository;
import projectarchi.repository.QuizRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;

    public QuestionService(QuestionRepository questionRepository, QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    public QuestionDTO convertToDTO(Question question) {
        // Récupération de tous les quiz associés à la question
        List<Quiz> quizzes = quizRepository.findByQuestions_Id(question.getId());
        List<QuizSummaryDTO> quizDTOs = quizzes.stream()
                .map(quiz -> new QuizSummaryDTO(quiz.getId(), quiz.getTitle()))
                .collect(Collectors.toList());



        return new QuestionDTO(
                question.getId(),
                question.getQuestionTitle(),
                question.getCategory(),
                question.getDifficultyLevel(),
                question.getOption1(),
                question.getOption2(),
                question.getOption3(),
                question.getOption4(),
                question.getRightAnswer(),
                quizDTOs
        );
    }

    public List<QuestionDTO> getAllQuestionDTOs() {
        return getAllQuestions().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
