package projectarchi.dto;

import java.time.LocalDateTime;
import java.util.List;

public class UserDTO {
    private Long id;  // Correspond à userId dans l'entité User
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime creationDate;
    private String role;  // "teacher" ou "student"
    private List<String> courseTitles; // Vous pouvez stocker ici les titres des cours associés, ou autre représentation si besoin

    public UserDTO() {
    }

    public UserDTO(Long id, String firstName, String lastName, String email, LocalDateTime creationDate, String role, List<String> courseTitles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.creationDate = creationDate;
        this.role = role;
        this.courseTitles = courseTitles;
    }

    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getCourseTitles() {
        return courseTitles;
    }

    public void setCourseTitles(List<String> courseTitles) {
        this.courseTitles = courseTitles;
    }
}
