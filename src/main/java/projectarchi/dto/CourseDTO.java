package projectarchi.dto;

import java.time.LocalDateTime;

public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private int examCount;
    private int enrolledCount;

    public CourseDTO() {
    }

    public CourseDTO(Long id, String title, String description, LocalDateTime creationDate, int examCount, int enrolledCount) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.examCount = examCount;
        this.enrolledCount = enrolledCount;
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    public int getExamCount() {
        return examCount;
    }
    public void setExamCount(int examCount) {
        this.examCount = examCount;
    }
    public int getEnrolledCount() {
        return enrolledCount;
    }
    public void setEnrolledCount(int enrolledCount) {
        this.enrolledCount = enrolledCount;
    }
}
