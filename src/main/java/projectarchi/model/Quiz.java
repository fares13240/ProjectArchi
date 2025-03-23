package projectarchi.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // Relation Many-to-Many avec Question via la table quiz_questions
    @ManyToMany
    @JoinTable(name = "quiz_questions",
            joinColumns = @JoinColumn(name = "quiz_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id"))
    private Set<Question> questions = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    public Quiz() {
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
    public Set<Question> getQuestions() {
        return questions;
    }
    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
