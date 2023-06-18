package org.example.relationships;

import org.example.dao.EmployeeDAO;
import org.example.dao.EmployeeDAOImpl;
import org.example.entities.Company;
import org.example.entities.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ManyToOneTest {

    @Test
    @DisplayName("TEST-ASSOC: Nto1 : Employees->Company")
    void manyToOneAssociationTest() {

        Employee employee1 = new Employee(null,
                                         "Employee to Company 1",
                                         "NtoOne 1",
                                         "employeesToCompany1@employee.com",
                                         99,
                                         00000.00,
                                         true,
                                         LocalDate.of(1999, 1, 1),
                                         LocalDateTime.now()
        );
        Employee employee2 = new Employee(null,
                                         "Employee to Company 2",
                                         "NtoOne 2",
                                         "employeesToCompany2@employee.com",
                                         99,
                                         00000.00,
                                         false,
                                         LocalDate.of(1999, 1, 1),
                                         LocalDateTime.now()
        );
        Employee employee3 = new Employee(null,
                                         "Employee to Company 3",
                                         "NtoOne 3",
                                         "employeesToCompany3@employee.com",
                                         99,
                                         00000.00,
                                         true,
                                         LocalDate.of(1999, 1, 1),
                                         LocalDateTime.now()
        );

        Company company = new Company(null, "20-12345678-9", "Test Company", 2019, 55000d);

        employee1.setCompany(company);
        employee2.setCompany(company);
        employee3.setCompany(company);

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        employeeDAO.createEmployee(employee1);
        employeeDAO.createEmployee(employee2);
        employeeDAO.createEmployee(employee3);

        Employee employeeDB = employeeDAO.findById(5l);
        System.out.println(employeeDB.getCompany());

    }
}
