package org.example.entities;

import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
}
