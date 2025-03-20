package projectarchi.dto;

public class QuestionDTO {
    private Long id;
    private String questionTitle;
    private Long quizId;
    private String quizTitle;

    public QuestionDTO() {
    }

    public QuestionDTO(Long id, String questionTitle, Long quizId, String quizTitle) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.quizId = quizId;
        this.quizTitle = quizTitle;
    }

    // Getters et setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getQuestionTitle() {
        return questionTitle;
    }
    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }
    public Long getQuizId() {
        return quizId;
    }
    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }
    public String getQuizTitle() {
        return quizTitle;
    }
    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }
}
