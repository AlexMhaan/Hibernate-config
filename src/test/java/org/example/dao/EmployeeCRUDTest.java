package org.example.dao;

import org.example.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

class EmployeeCRUDTest {

    EmployeeDAO dao;

    @BeforeEach
    void setUp() {
        dao = new EmployeeDAOImpl();
    }

    @Test
    void findAll() {
        List<Employee> employees = dao.findAll();
        System.out.println(employees);
    }

    @Test
    void findById() {
        Employee employee1 = dao.findById(1L);
        Employee employee2 = dao.findById(2L);
        Employee employee3 = dao.findById(4L);


    }

    @Test
    void findByFirstName() {
        List<Employee> employees = dao.findByFirstName('jua');
        System.out.println(employees);

    }

    @Test
    void findByLastName() {
    }

    @Test
    void findByEmail() {
    }

    @Test
    void findByAge() {

        List<Employee> employe20 = dao.findByAge(20);
        List<Employee> employe22 = dao.findByAge(22);
        List<Employee> employe44 = dao.findByAge(44);


    }

    @Test
    void testFindByAge() {
    }

    @Test
    void testFindByAge1() {
    }

    @Test
    void createEmployee() {
        Employee employee = new Employee(null, "Test", "Test", "Test@Test.com", 00, 0000.00, false, LocalDate.now(), LocalDateTime.now());
        employee = dao.createEmployee(employee);
        System.out.println(employee);
    }

    @Test
    void updateEmployee() {
        Employee employee = new Employee(1L, "modif", "modif", "modif@modif.com", null, null, null, null, null);
        dao.updateEmployee(employee);
        System.out.println(employee);
    }

    @Test
    void deleteById() {
        boolean result = dao.deleteById(1L);
        System.out.println(result);
    }
}