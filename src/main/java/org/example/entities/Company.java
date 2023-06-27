package org.example.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Audited
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String CUIT;

    @Column(name = "legal_name")
    private String legalName;

    @Column(name = "since_year")
    private Integer sinceYear;

    private Double capital;

    @OneToMany(mappedBy = "company")
    List<Employee> employees = new ArrayList<>();

    @Column(name = "created_on")
    @CreationTimestamp
    LocalDateTime createdOn;

    public Company(){}

    public Company(
            Long id,
            String CUIT,
            String legalName,
            Integer sinceYear,
            Double capital
    ) {
        this.id = id;
        this.CUIT = CUIT;
        this.legalName = legalName;
        this.sinceYear = sinceYear;
        this.capital = capital;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCUIT() {
        return CUIT;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public Integer getSinceYear() {
        return sinceYear;
    }

    public void setSinceYear(Integer sinceYear) {
        this.sinceYear = sinceYear;
    }

    public Double getCapital() {
        return capital;
    }

    public void setCapital(Double capital) {
        this.capital = capital;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", CUIT='" + CUIT + '\'' +
                ", legalName='" + legalName + '\'' +
                ", sinceYear=" + sinceYear +
                ", capital=" + capital +
                '}';
    }
}
