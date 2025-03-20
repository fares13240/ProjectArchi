package projectarchi.dto;

import java.time.LocalDateTime;

public class ExamDTO {
    private Long id;
    private String examTitle;
    private LocalDateTime creationDate;
    private int quizCount;
    private Long courseId;
    private String courseTitle;

    public ExamDTO() {
    }

    public ExamDTO(Long id, String examTitle, LocalDateTime creationDate, int quizCount, Long courseId, String courseTitle) {
        this.id = id;
        this.examTitle = examTitle;
        this.creationDate = creationDate;
        this.quizCount = quizCount;
        this.courseId = courseId;
        this.courseTitle = courseTitle;
    }

    // Getters et setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getExamTitle() {
        return examTitle;
    }
    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    public int getQuizCount() {
        return quizCount;
    }
    public void setQuizCount(int quizCount) {
        this.quizCount = quizCount;
    }
    public Long getCourseId() {
        return courseId;
    }
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
    public String getCourseTitle() {
        return courseTitle;
    }
    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
}
