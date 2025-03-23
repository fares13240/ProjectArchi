package projectarchi.dto;

import projectarchi.model.Question;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class QuizDTO {
    private Long id;
    private String title;
    private LocalDateTime creationDate;
    private int questionCount;
    private Long examId;
    private String examTitle;
    private Set<Question> questions = new HashSet<>();

    public QuizDTO() {
    }

    public QuizDTO(Long id, String title, LocalDateTime creationDate, int questionCount, Long examId, String examTitle, Set<Question> questions) {
        this.id = id;
        this.title = title;
        this.creationDate = creationDate;
        this.questionCount = questionCount;
        this.examId = examId;
        this.examTitle = examTitle;
        this.questions = questions;
    }

    // Getters et setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    public int getQuestionCount() {
        return questionCount;
    }
    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }
    public Long getExamId() {
        return examId;
    }
    public void setExamId(Long examId) {
        this.examId = examId;
    }
    public String getExamTitle() {
        return examTitle;
    }
    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
