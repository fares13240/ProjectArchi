package projectarchi.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

    // @ID This annotation specifies
    // the primary key of the entity.
    @Id

    // @GeneratedValue This annotation
    // is used to specify the primary
    // key generation strategy to use
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Column
    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    // Hibernate expects entities to have a no-arg constructor,
    // though it does not necessarily have to be public.
    protected Employee() {
    }

    public Employee(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return this.id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }
}