package projectarchi.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "exam")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String examTitle;

    // Relation Many-to-One avec Course (remplace course_id par une entité Course)
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    // Relation Many-to-One avec User pour l'enseignant (teacher_id)
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User teacher;

    // Relation One-to-Many avec Question
    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Question> questions = new HashSet<>();

    // Relation Many-to-Many avec User pour les étudiants inscrits (table exam_students)
    @ManyToMany
    @JoinTable(name = "exam_students",
            joinColumns = @JoinColumn(name = "exam_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<User> examStudents = new HashSet<>();

    public Exam() {
    }

    // Getters and Setters
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
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public User getTeacher() {
        return teacher;
    }
    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }
    public Set<Question> getQuestions() {
        return questions;
    }
    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
    public Set<User> getExamStudents() {
        return examStudents;
    }
    public void setExamStudents(Set<User> examStudents) {
        this.examStudents = examStudents;
    }
}
