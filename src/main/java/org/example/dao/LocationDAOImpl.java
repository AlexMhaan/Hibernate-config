package org.example.dao;

import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.entities.Location;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class LocationDAOImpl implements LocationDAO{

    @Override
    public List<Location> findAll() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Location> locations = session.createQuery("from Location", Location.class).list();

        session.close();
        return locations;
    }

    @Override
    public List<Location> findAllCriteria() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Location> criteria = builder.createQuery(Location.class);

        Root<Location> root = criteria.from(Location.class);
        criteria.select(root);
        List<Location> locations = session.createQuery(criteria).list();

        session.close();
        return locations;
    }

    @Override
    public Location findById(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Location location = session.find(Location.class,id);

        session.close();
        return location;
    }

    @Override
    public Location findByIdCriteria(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Location> criteria = builder.createQuery(Location.class);

        Root<Location> root = criteria.from(Location.class);
        Predicate filter = builder.equal(root.get("id"), id);
        criteria.select(root).where(filter);
        Location location = session.createQuery(criteria).getSingleResult();

        session.close();
        return location;
    }

    @Override
    public Location createLocation(Location location) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(location);
            session.getTransaction().commit();
        }catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        session.close();
        return location;
    }

    @Override
    public Location updateLocation(Location location) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.merge(location);
            session.getTransaction().commit();
        }catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return location;
    }

    @Override
    public boolean deleteLocationById(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Location location = this.findById(id);
            session.remove(location);
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

    @Override
    public List<Location> findByStreetName(String StreetName) {
        return null;
    }

    @Override
    public List<Location> findByStreetNameCriteria(String StreetName) {
        return null;
    }

    @Override
    public List<Location> findByZIPCode(String ZIPCode) {
        return null;
    }

    @Override
    public List<Location> findByZIPCodeCriteria(String ZIPCode) {
        return null;
    }

    @Override
    public List<Location> findByCityName(String cityName) {
        return null;
    }

    @Override
    public List<Location> findByCityNameCriteria(String cityName) {
        return null;
    }

    @Override
    public List<Location> findByCountryName(String countryName) {
        return null;
    }

    @Override
    public List<Location> findByCountryNameCriteria(String countryName) {
        return null;
    }
}
