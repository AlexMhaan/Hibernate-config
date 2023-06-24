package org.example.dao;

import org.example.dto.EmployeeDTO;
import org.example.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class EmployeeNativeTest {

    EmployeeDAO employeeDAO;

    @BeforeEach
    void setUp() {
        employeeDAO = new EmployeeDAOImpl();
    }

    @Test
    void findByIdNative() {
        Object[] employee = employeeDAO.findByIdNative(1L);
        String employeeString = Arrays.toString(employee);
        System.out.println(employeeString);
    }

    @Test
    void findAllNative() {
        List<Employee> employees = employeeDAO.findAllNative();
        System.out.println(employees);
    }

    @Test
    void findByIdProjection() {
        List<EmployeeDTO> employees = employeeDAO.findAllProjection();
        System.out.println(employees);
    }
}
