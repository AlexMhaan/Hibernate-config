package org.example.relationships;

import org.example.dao.EmployeeDAO;
import org.example.dao.EmployeeDAOImpl;
import org.example.dao.LocationDAO;
import org.example.dao.LocationDAOImpl;
import org.example.entities.Car;
import org.example.entities.Employee;
import org.example.entities.EmployeeSeniority;
import org.example.entities.Location;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class OneToManyTest {

    @Test
    @DisplayName("TEST-ASSOC: 1toN : Employee->Cars")
    void oneToOneAssociationTest() {


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
        employee.getNicks().add("'Juance'");
        employee.setSeniority(EmployeeSeniority.JUNIOR);

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        employeeDAO.createEmployee(employee);

        Employee employeeDB = employeeDAO.findByIdEager(5L);
        System.out.println(employeeDB);
        List<Car> cars = employeeDB.getCars();
        System.out.println(cars);


    }
}
