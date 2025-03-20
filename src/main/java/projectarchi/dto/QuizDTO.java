package projectarchi.dto;

import java.time.LocalDateTime;

public class QuizDTO {
    private Long id;
    private String title;
    private LocalDateTime creationDate;
    private int questionCount;
    private Long examId;
    private String examTitle;

    public QuizDTO() {
    }

    public QuizDTO(Long id, String title, LocalDateTime creationDate, int questionCount, Long examId, String examTitle) {
        this.id = id;
        this.title = title;
        this.creationDate = creationDate;
        this.questionCount = questionCount;
        this.examId = examId;
        this.examTitle = examTitle;
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
}
