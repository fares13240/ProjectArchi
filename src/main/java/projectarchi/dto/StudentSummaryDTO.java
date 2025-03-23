package projectarchi.dto;

public class StudentSummaryDTO {
    private String firstName;
    private String lastName;
    private Long userId;

    public StudentSummaryDTO() {
    }

    public StudentSummaryDTO(Long userId, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;    }

    // Getters & Setters
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
