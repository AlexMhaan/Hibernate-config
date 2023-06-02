package org.example.dao;

import org.example.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EmployeeCriteriaTest {

    EmployeeDAO dao;

    @BeforeEach
    void setUp() {
        dao = new EmployeeDAOImpl();
    }


    @Test
    void findAllCriteria() {
        List<Employee> employees = dao.findAllCriteria();
        System.out.println(employees);
    }


    @Test
    void findByIdCriteria() {
        Employee employee = dao.findByIdCriteria(2L);
        System.out.println(employee);
    }

    @Test
    void findByFirstNameCriteria() {
        List<Employee> employee = dao.findByFirstNameCriteria("e");
        System.out.println(employee);
    }
    @Test
    void findByLastNameCriteria() {
        List<Employee> employee = dao.findByLastNameCriteria("la");
        System.out.println(employee);
    }
}
