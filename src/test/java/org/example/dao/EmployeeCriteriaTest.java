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

    @Test
    void findByEmailCriteria() {
        Employee employee = dao.findByEmailCriteria("empleado2@employee.com");
        System.out.println(employee);
    }

    @Test
    void findByAgeCriteria() {
        List<Employee> employee = dao.findByAgeCriteria(35);
        System.out.println(employee);
    }

    @Test
    void findByAgeGTCriteria() {
        List<Employee> employee = dao.findByAgeGTCriteria(36);
        System.out.println(employee);
    }

    @Test
    void findByBTSalaryCriteria() {
        List<Employee> employee = dao.findByBTSalaryCriteria(55000.00, 88000.00);
        System.out.println(employee);
    }

    @Test
    void findByMarriageCriteria() {
        List<Employee> employee = dao.findByMarriageCriteria(false);
        System.out.println(employee);
    }


}
