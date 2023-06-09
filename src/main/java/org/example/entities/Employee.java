package org.example.entities;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 30, nullable = false)
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(unique=true)
    private String email;

    private Integer age;
    private Double salary;
    private Boolean married;
    @Column(name="birth_date")
    private LocalDate birthDate;
    @Column(name="creation_date")
    private LocalDateTime creationDate;

//    @OneToOne(cascade=CascadeType.ALL)
    @OneToOne
    @JoinColumn(name="locations_pk", foreignKey=@ForeignKey(name = "fk_employees_locations"))
    Location location;

    @ElementCollection
    private List<String> nicks = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    EmployeeSeniority seniority;

    public Employee(){}

    public Employee(
            Long id,
            String firstName,
            String lastName,
            String email,
            Integer age,
            Double salary,
            Boolean married,
            LocalDate birthDate,
            LocalDateTime creationDate
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.married = married;
        this.birthDate = birthDate;
        this.creationDate = creationDate;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public List<String> getNicks() { return nicks; }

    public void setNicks(List<String> nicks) { this.nicks = nicks; }

    public EmployeeSeniority getSeniority() { return seniority; }

    public void setSeniority(EmployeeSeniority seniority) { this.seniority = seniority; }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", FirstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", married=" + married +
                ", birthDate=" + birthDate +
                ", creationDate=" + creationDate +
                '}';
    }
}
