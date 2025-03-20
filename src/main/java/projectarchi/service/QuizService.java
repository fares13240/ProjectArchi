package projectarchi.service;

import org.springframework.stereotype.Service;
import projectarchi.dto.QuizDTO;
import projectarchi.model.Quiz;
import projectarchi.repository.QuizRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {
    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Optional<Quiz> getQuizById(Long id) {
        return quizRepository.findById(id);
    }

    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }

    public QuizDTO convertToDTO(Quiz quiz) {
        int questionCount = quiz.getQuestions() != null ? quiz.getQuestions().size() : 0;
        Long examId = null; // Si vous avez une relation avec Exam, récupérez-la ici
        String examTitle = null; // idem
        return new QuizDTO(
                quiz.getId(),
                quiz.getTitle(),
                null, // creationDate
                questionCount,
                examId,
                examTitle
        );
    }

    public List<QuizDTO> getAllQuizDTOs() {
        return getAllQuizzes().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
