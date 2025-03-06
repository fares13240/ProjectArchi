package projectarchi.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private boolean active;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String role;
    private String username;

    // Relation Many-to-Many avec Exam (pour les inscriptions aux examens)
    @ManyToMany(mappedBy = "examStudents")
    private Set<Exam> exams = new HashSet<>();

    // Relation Many-to-Many avec Course (pour les inscriptions aux cours)
    @ManyToMany(mappedBy = "students")
    private Set<Course> courses = new HashSet<>();

    public User() {
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Set<Exam> getExams() {
        return exams;
    }
    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }
    public Set<Course> getCourses() {
        return courses;
    }
    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
