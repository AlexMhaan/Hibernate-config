package org.example.dao;

import org.example.entities.Employee;
import org.example.entities.EmployeeSeniority;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EmployeeCriteriaTest {

    EmployeeDAO employeeDAO;

    @BeforeEach
    void setUp() {
        employeeDAO = new EmployeeDAOImpl();
    }

    @Test
    void findAllCriteria() {
        List<Employee> employees = employeeDAO.findAllCriteria();
        System.out.println(employees);
    }

    @Test
    void findByIdCriteria() {
        Employee employee = employeeDAO.findByIdCriteria(2L);
        System.out.println(employee);
    }

    @Test
    void findByFirstNameCriteria() {
        List<Employee> employee = employeeDAO.findByFirstNameCriteria("e");
        System.out.println(employee);
    }

    @Test
    void findByLastNameCriteria() {
        List<Employee> employee = employeeDAO.findByLastNameCriteria("la");
        System.out.println(employee);
    }

    @Test
    void findByEmailCriteria() {
        Employee employee = employeeDAO.findByEmailCriteria("empleado2@employee.com");
        System.out.println(employee);
    }

    @Test
    void findByAgeCriteria() {
        List<Employee> employee = employeeDAO.findByAgeCriteria(35);
        System.out.println(employee);
    }

    @Test
    void findByAgeGTCriteria() {
        List<Employee> employee = employeeDAO.findByAgeGTCriteria(36);
        System.out.println(employee);
    }

    @Test
    void findByBTSalaryCriteria() {
        List<Employee> employee = employeeDAO.findByBTSalaryCriteria(55000.00, 88000.00);
        System.out.println(employee);
    }

    @Test
    void findByMarriageCriteria() {
        List<Employee> employee = employeeDAO.findByMarriageCriteria(false);
        System.out.println(employee);
    }

    @Test
    void findBetweenAgeAndSeniorityByCriteria() {
        List<Employee> employees = employeeDAO.findBetweenAgeAndSeniorityByCriteria(20, 38, EmployeeSeniority.TRAINEE);
        System.out.println(employees);

    }

    @Test
    void findAvgAgeCriteria() {
        Integer averAge = employeeDAO.findAvgAgeCriteria();
        System.out.println(averAge);
    }
}
