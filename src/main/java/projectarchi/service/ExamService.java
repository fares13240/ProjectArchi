package projectarchi.service;

import org.springframework.stereotype.Service;
import projectarchi.dto.ExamDTO;
import projectarchi.model.Exam;
import projectarchi.repository.ExamRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExamService {
    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public Optional<Exam> getExamById(Long id) {
        return examRepository.findById(id);
    }

    public Exam saveExam(Exam exam) {
        return examRepository.save(exam);
    }

    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }

    public ExamDTO convertToDTO(Exam exam) {
        int quizCount = 0; // Adaptation : si vous avez une relation avec Quiz, remplacez par exam.getQuizzes().size();
        Long courseId = exam.getCourse() != null ? exam.getCourse().getId() : null;
        String courseTitle = exam.getCourse() != null ? exam.getCourse().getTitle() : null;
        return new ExamDTO(
                exam.getId(),
                exam.getExamTitle(),
                null,  // creationDate
                quizCount,
                courseId,
                courseTitle
        );
    }

    public List<ExamDTO> getAllExamDTOs() {
        return getAllExams().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
