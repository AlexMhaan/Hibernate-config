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

public class OneToOneTest {

    @Test
    @DisplayName("TEST-ASSOC: 1to1 : Employee->Location")
    void oneToOneAssociationTest() {

        Location location = new Location(null, "Calle falsa 5", "CP0Test", "Bs.As.", "Argenturria");

        Employee employee = new Employee(null,
                                         "Employee to Location",
                                         "1to1",
                                         "employeeToLocation@employee.com",
                                         99,
                                         00000.00,
                                         false,
                                         LocalDate.of(1999, 1, 1),
                                         LocalDateTime.now()
        );

        employee.getNicks().add("'EL PEPE'");
        employee.setSeniority(EmployeeSeniority.SENIOR);
//        employee.setLocation(location);

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        LocationDAO locationDAO = new LocationDAOImpl();

        locationDAO.createLocation(location);
        employeeDAO.createEmployee(employee);

//        System.out.println(employee.getLocation());
        System.out.println(employee.getNicks());

    }
}
