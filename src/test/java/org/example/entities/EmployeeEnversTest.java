package org.example.entities;

import org.example.dao.CarDAO;
import org.example.dao.CarDAOImpl;
import org.example.dao.EmployeeDAO;
import org.example.dao.EmployeeDAOImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmployeeEnversTest {
    EmployeeDAO employeeDAO;
    CarDAO carDAO;

    @BeforeEach
    void setUp() {
        employeeDAO = new EmployeeDAOImpl();
        carDAO = new CarDAOImpl();
    }

    @Test
    void createEmployee() {

        Employee employee = new Employee(null,
                                         "Employee Envers",
                                         "Employee TEST",
                                         "empleadoEnversTest@employee.com",
                                         00,
                                         00000.00,
                                         false,
                                         LocalDate.of(1999, 1, 1)
        );

        Car car1 = new Car(null, "Chevrolet", "Cruze", 1.80, 2011);
        Car car2 = new Car(null, "Nissan", "Versa", 1.60, 2017);

        employee.getCars().add(car1);
        employee.getCars().add(car2);

        carDAO.createCar(car1);
        carDAO.createCar(car2);

        employee.setSalary(50000D);

        employeeDAO.createEmployee(employee);


        employee.setAge(35);

        employee.setSalary(55000D);

        employeeDAO.updateEmployee(employee);

        employee.setEmail("employeeEnvers@employee.com");
        employee.setSalary(60000D);

        employeeDAO.updateEmployee(employee);

        employee.getCars().clear();
        employee.getCars().add(car1);
        employee.setSalary(77000D);

        employeeDAO.updateEmployee(employee);

    }
}

