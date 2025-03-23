package projectarchi.service;

import org.springframework.stereotype.Service;
import projectarchi.dto.QuestionDTO;
import projectarchi.model.Question;
import projectarchi.repository.QuestionRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
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
        Long quizId = null;
        String quizTitle = null;
        return new QuestionDTO(
                question.getId(),
                question.getQuestionTitle(),
                quizId,
                quizTitle
        );
    }

    public List<QuestionDTO> getAllQuestionDTOs() {
        return getAllQuestions().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
