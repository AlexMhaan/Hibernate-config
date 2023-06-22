package org.example.dto;


import jakarta.persistence.Transient;

public class EmployeeDTO {

    @Transient
    private Long id;

    @Transient
    private String email;

    public EmployeeDTO(){}

    public EmployeeDTO(Long id, String email) {
        this.id = id;
        this.email = email;
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

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}