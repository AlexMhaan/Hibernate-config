package org.example.relationships;

import org.example.dao.EmployeeDAO;
import org.example.dao.EmployeeDAOImpl;
import org.example.entities.Employee;
import org.example.entities.Project;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ManyToManyTest {

    @Test
    @DisplayName("TEST-ASSOC: NtoN : Employees<->Projects")
    void manyToManyAssociationTest() {

        Project project1 = new Project(null, "Project X", LocalDate.now());
        Project project2 = new Project(null, "Project Y", LocalDate.now());

        Employee employee1 = new Employee(null,
                                          "Employee to Project 1",
                                          "NtoN 1",
                                          "employeesToProyect1@employee.com",
                                          99,
                                          00000.00,
                                          true,
                                          LocalDate.of(1999, 1, 1),
                                          LocalDateTime.now()
        );
        Employee employee2 = new Employee(null,
                                          "Employee to Project 2",
                                          "NtoN 2",
                                          "employeesToProyect2@employee.com",
                                          99,
                                          00000.00,
                                          false,
                                          LocalDate.of(1999, 1, 1),
                                          LocalDateTime.now()
        );

        employee1.getProjects().add(project1);
        employee1.getProjects().add(project2);
        employee2.getProjects().add(project1);
        employee2.getProjects().add(project2);

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeDAO.createEmployee(employee1);
        employeeDAO.createEmployee(employee2);


    }
}
