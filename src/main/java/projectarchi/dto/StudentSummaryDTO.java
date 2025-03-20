package projectarchi.dto;

public class StudentSummaryDTO {
    private String firstName;
    private String lastName;

    public StudentSummaryDTO() {
    }

    public StudentSummaryDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

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
}
