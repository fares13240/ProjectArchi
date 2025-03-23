package projectarchi.dto;

import java.util.List;

public class QuestionDTO {
    private Long id;
    private String questionTitle;
    private String category;
    private String difficultyLevel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int rightAnswer;
    private Long quizId;
    private String quizTitle;
    private List<QuizSummaryDTO> quizzes;  // Liste de tous les quiz associés

    public QuestionDTO() {
    }

    public QuestionDTO(Long id, String questionTitle, String category, String difficultyLevel,
                       String option1, String option2, String option3, String option4, int rightAnswer, List<QuizSummaryDTO> quizzes) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.category = category;
        this.difficultyLevel = difficultyLevel;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.rightAnswer = rightAnswer;
        this.quizzes = quizzes;
    }

    // Getters et setters...

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
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getDifficultyLevel() {
        return difficultyLevel;
    }
    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
    public String getOption1() {
        return option1;
    }
    public void setOption1(String option1) {
        this.option1 = option1;
    }
    public String getOption2() {
        return option2;
    }
    public void setOption2(String option2) {
        this.option2 = option2;
    }
    public String getOption3() {
        return option3;
    }
    public void setOption3(String option3) {
        this.option3 = option3;
    }
    public String getOption4() {
        return option4;
    }
    public void setOption4(String option4) {
        this.option4 = option4;
    }
    public int getRightAnswer() {
        return rightAnswer;
    }
    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
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
    public List<QuizSummaryDTO> getQuizzes() {
        return quizzes;
    }
    public void setQuizzes(List<QuizSummaryDTO> quizzes) {
        this.quizzes = quizzes;
    }
}
