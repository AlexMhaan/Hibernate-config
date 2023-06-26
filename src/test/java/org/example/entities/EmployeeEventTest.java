package org.example.entities;

import org.example.dao.EmployeeDAO;
import org.example.dao.EmployeeDAOImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmployeeEventTest {
    EmployeeDAO employeeDAO;

    @BeforeEach
    void setUp() {
        employeeDAO = new EmployeeDAOImpl();
    }

    @Test
    void prePersist() {

        Employee employee = new Employee(null,
                                         "Employee EVENT",
                                         "Employee TEST",
                                         "empleadoEventTest@employee.com",
                                         00,
                                         00000.00,
                                         false,
                                         LocalDate.of(1999, 1, 1)
        );

        employeeDAO.createEmployee(employee);
    }

    @Test
    void preUpdate() {

        Employee employee = employeeDAO.findByIdCriteria(1L);

        employee.setAge(99);
        employeeDAO.updateEmployee(employee);
    }

}
