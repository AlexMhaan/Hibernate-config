package org.example.dao;

import org.example.entities.Employee;
import org.example.entities.EmployeeSeniority;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

class EmployeeCRUDTest {

    EmployeeDAO employeeDAO;

    @BeforeEach
    void setUp() {
        employeeDAO = new EmployeeDAOImpl();
    }

    @Test
    void findAll() {
        List<Employee> employees = employeeDAO.findAll();
        System.out.println(employees);
    }

    @Test
    void findById() {
        Employee employee = employeeDAO.findById(2L);
        System.out.println(employee);
    }

    @Test
    void findByFirstName() {
        List<Employee> employees = employeeDAO.findByFirstName("ani");
        System.out.println(employees);
    }

    @Test
    void findByLastName() {
        List<Employee> employees = employeeDAO.findByLastName("ap");
        System.out.println(employees);
    }

    @Test
    void findByEmail() {
        Employee employee = employeeDAO.findByEmail("empleado2@employee.com");
        System.out.println(employee);
    }

    @Test
    void findByAge() {
        List<Employee> employee = employeeDAO.findByAge(35);
        System.out.println(employee);
    }

    @Test
    void findByAgeGT() {
        List<Employee> employee = employeeDAO.findByAgeGT(35);
        System.out.println(employee);
    }

    @Test
    void findByBTSalary() {
        List<Employee> employee = employeeDAO.findByBTSalary(55000.00, 88000.00);
        System.out.println(employee);
    }

    @Test
    void findByMarriage() {
        List<Employee> employee = employeeDAO.findByMarriage(false);
        System.out.println(employee);
    }

    @Test
    void findBetweenAgeAndSeniority() {
        List<Employee> employee = employeeDAO.findBetweenAgeAndSeniority(20, 38, EmployeeSeniority.TRAINEE);
        System.out.println(employee);
    }

    @Test
    void createEmployee() {
        Employee employee = new Employee(null, "Test", "Test", "Test@Test.com", 00, 0000.00, false, LocalDate.now(), LocalDateTime.now());
        employee = employeeDAO.createEmployee(employee);
        System.out.println(employee);
    }

    @Test
    void updateEmployee() {
        Employee employee = new Employee(1L, "modif", "modif", "modif@modif.com", null, null, null, null, null);
        employeeDAO.updateEmployee(employee);
        System.out.println(employee);
    }

    @Test
    void deleteById() {
        boolean result = employeeDAO.deleteById(1L);
        System.out.println(result);
    }

}