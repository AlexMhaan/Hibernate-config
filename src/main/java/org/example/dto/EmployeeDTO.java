package org.example.dto;

import jakarta.persistence.Transient;

public class EmployeeDTO {

    @Transient
    private Long id;

    @Transient
    private String email;

    @Transient
    private Double salary;

    public EmployeeDTO(){}

    public EmployeeDTO(
            Long id,
            String email,
            Double salary
    ) {
        this.id = id;
        this.email = email;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", salary=" + salary + '\n' +
                '}';
    }
}
