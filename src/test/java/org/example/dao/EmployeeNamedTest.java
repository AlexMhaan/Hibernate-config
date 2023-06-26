package org.example.dao;

import org.example.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EmployeeNamedTest {

    EmployeeDAO employeeDAO;

    @BeforeEach
    void setUp() {
        employeeDAO = new EmployeeDAOImpl();
    }

    @Test
    void findHigherSalary() {
        List<Employee> employees = employeeDAO.findHigherSalary();
        System.out.println(employees);
    }
}
