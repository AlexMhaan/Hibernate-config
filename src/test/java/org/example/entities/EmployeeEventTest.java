package org.example.entities;

import org.example.dao.CarDAO;
import org.example.dao.CarDAOImpl;
import org.example.dao.EmployeeDAO;
import org.example.dao.EmployeeDAOImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class EmployeeEventTest {
    EmployeeDAO employeeDAO;
    CarDAO carDAO;

    @BeforeEach
    void setUp() {
        employeeDAO = new EmployeeDAOImpl();
        carDAO = new CarDAOImpl();
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
    @Test
    void preRemoveEmployee(){

        Employee employee = new Employee(null,
                                         "Employee to Location",
                                         "1toN",
                                         "empleadoToManyCars@employee.com",
                                         99,
                                         00000.00,
                                         true,
                                         LocalDate.of(1999, 1, 1),
                                         LocalDateTime.now()
        );

        Car car1 = new Car(null,"Chevrolet", "Cruze", 1.80, 2011);
        Car car2 = new Car(null,"Nissan", "Versa", 1.60, 2017);

        employee.getCars().add(car1);
        employee.getCars().add(car2);

        carDAO.createCar(car1);
        carDAO.createCar(car2);
        employeeDAO.createEmployee(employee);
        employeeDAO.deleteById(employee.getId());

//        Employee employeeDB = employeeDAO.findByIdEager(5L);
//        System.out.println(employeeDB);
//        List<Car> cars = employeeDB.getCars();
//        System.out.println(cars);
    }

    @Test
    void preRemoveCar() {

        Employee employee = new Employee(null,
                                         "Employee to Location",
                                         "1toN",
                                         "empleadoToManyCars@employee.com",
                                         99,
                                         00000.00,
                                         true,
                                         LocalDate.of(1999, 1, 1),
                                         LocalDateTime.now()
        );

        Car car1 = new Car(null, "Chevrolet", "Cruze", 1.80, 2011);
        Car car2 = new Car(null, "Nissan", "Versa", 1.60, 2017);

        employee.getCars().add(car1);
        employee.getCars().add(car2);

        carDAO.createCar(car1);
        carDAO.createCar(car2);
        employeeDAO.createEmployee(employee);

        carDAO.deleteCarById(car2.getId());
    }

}
