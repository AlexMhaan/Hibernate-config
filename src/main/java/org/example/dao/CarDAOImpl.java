package org.example.dao;

import jakarta.persistence.PersistenceException;
import org.example.entities.Car;
import org.example.entities.Employee;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

public class CarDAOImpl implements CarDAO {
    @Override
    public Car findCarById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Car car = session.find(Car.class, id);

        session.close();
        return car;
    }

    @Override
    public Car createCar(Car car) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(car);
            session.getTransaction().commit();
        }catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        session.close();
        return car;
    }

    @Override
    public Car updateCar(Car car) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.merge(car);
            session.getTransaction().commit();
        }catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return car;
    }

    @Override
    public boolean deleteCarById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Car car = this.findCarById(id);
            session.remove(car);
            session.getTransaction().commit();
        }catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
        return true;
    }

}
