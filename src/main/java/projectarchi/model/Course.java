package projectarchi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // Relation One-to-Many avec Exam
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private Set<Exam> exams = new HashSet<>();

    // Relation Many-to-Many avec User pour les étudiants inscrits (table course_students)
    @ManyToMany
    @JoinTable(name = "course_students",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<User> students = new HashSet<>();

    public Course() {
    }

    // Getters and Setters
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
    public Set<Exam> getExams() {
        return exams;
    }
    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }
    public Set<User> getStudents() {
        return students;
    }
    public void setStudents(Set<User> students) {
        this.students = students;
    }
}
