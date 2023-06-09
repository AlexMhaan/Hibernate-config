package org.example.entities;

import org.example.dao.EmployeeDAO;
import org.example.dao.EmployeeDAOImpl;
import org.example.dao.LocationDAO;
import org.example.dao.LocationDAOImpl;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EntitiesTest {

    @Test
    void createTableTest() {


        Employee empleado1 = new Employee(null,
                                          "Pedro",
                                          "Marmol",
                                          "empleado2@employee.com",
                                          35,
                                          50000.00,
                                          false,
                                          LocalDate.of(1988, 1, 1),
                                          LocalDateTime.now());

        Employee empleado2 = new Employee(null,
                                          "Pablo",
                                          "Picapiedra",
                                          "empleado3@employee.com",
                                          40,
                                          55500.00,
                                          true,
                                          LocalDate.of(1983, 10, 10),
                                          LocalDateTime.now());

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.persist(empleado1);
        session.persist(empleado2);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
        HibernateUtil.shutdown();
    }

    @Test
    void nicksTest() {
        Employee employee = new Employee(null,
                                          "Employee con nick",
                                          "Employee con nick",
                                          "empleado@employee.com",
                                          00,
                                          00000.00,
                                          false,
                                          LocalDate.of(1999, 1, 1),
                                          LocalDateTime.now()
        );

        employee.getNicks().add("nick1");
        employee.getNicks().add("nick2");
        employee.getNicks().add("nick3");

        employee.setSeniority(EmployeeSeniority.ARCHITECT);

        EmployeeDAO dao = new EmployeeDAOImpl();
        dao.createEmployee(employee);

    }@Test
    @DisplayName(" test association: 1 to 1 : Employee to Location.")
    void oneToOneAssociationTest() {

        Location location = new Location(null,"Calle falsa 5", "CP0Test","Bs.As.", "Argenturria");

        Employee employee = new Employee(null,
                                          "Employee to Location",
                                          "1 on 1",
                                          "empleado5@employee.com",
                                          00,
                                          00000.00,
                                          false,
                                          LocalDate.of(1999, 1, 1),
                                          LocalDateTime.now()
        );

        employee.getNicks().add("'EL PEPE'");
        employee.setSeniority(EmployeeSeniority.SENIOR);
        employee.setLocation(location);


        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        LocationDAO locationDAO = new LocationDAOImpl();


        locationDAO.createLocation(location);
        employeeDAO.createEmployee(employee);

    }
}
