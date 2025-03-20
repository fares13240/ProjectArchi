package projectarchi.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CourseDTO {
    private Long id;
    private String title;
    private String description; // Facultatif (si existant dans Course)
    private LocalDateTime creationDate; // Facultatif (si existant dans Course)
    private int examCount;
    private int enrolledCount;
    private List<StudentSummaryDTO> enrolledStudents; // Résumé des étudiants inscrits

    public CourseDTO() {
    }

    public CourseDTO(Long id, String title, String description, LocalDateTime creationDate, int examCount, int enrolledCount, List<StudentSummaryDTO> enrolledStudents) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.examCount = examCount;
        this.enrolledCount = enrolledCount;
        this.enrolledStudents = enrolledStudents;
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

    public List<StudentSummaryDTO> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<StudentSummaryDTO> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
}
