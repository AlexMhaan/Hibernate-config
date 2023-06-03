package org.example.dao;

import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.entities.Employee;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{

    @Override
    public List<Employee> findAll() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees = session.createQuery("from Employee", Employee.class).list();

        session.close();
        return employees;
    }

    @Override
    public List<Employee> findAllCriteria() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);

        Root<Employee> root = criteria.from(Employee.class);
        criteria.select(root);
        List<Employee> employees = session.createQuery(criteria).list();

        session.close();
        return employees;
    }

    @Override
    public Employee findById(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee employee = session.find(Employee.class, id);

        session.close();
        return employee;
    }

    @Override
    public Employee findByIdCriteria(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);

        Root<Employee> root = criteria.from(Employee.class);
        Predicate filter = builder.equal(root.get("id"), id);
        criteria.select(root).where(filter);
        Employee employee = session.createQuery(criteria).getSingleResult();

        session.close();
        return employee;
    }

    @Override
    public List<Employee> findByFirstName(String firstName) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "from Employee where firstName like :firstName";
        List<Employee> employees = session.createQuery(query, Employee.class)
                .setParameter(("firstName"), "%" + firstName + "%") // Set the parameter value
                .list();

        session.close();
        return employees;
    }

    @Override
    public List<Employee> findByFirstNameCriteria(String firstName) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);

        Root<Employee> root = criteria.from(Employee.class);
        Predicate filter = builder.like(root.get("firstName"), "%" + firstName + "%");
        criteria.select(root).where(filter);
        List<Employee> employees = session.createQuery(criteria).list();

        session.close();
        return employees;
    }

    @Override
    public List<Employee> findByLastName(String lastName) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "from Employee where lastName like :lastName";
        List<Employee> employees = session.createQuery(query, Employee.class)
                .setParameter(("lastName"), "%" + lastName + "%") // Set the parameter value
                .list();

        session.close();
        return employees;
    }

    @Override
    public List<Employee> findByLastNameCriteria(String lastName) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);

        Root<Employee> root = criteria.from(Employee.class);
        Predicate filter = builder.like(root.get("lastName"), "%" + lastName + "%");
        criteria.select(root).where(filter);
        List<Employee> employees = session.createQuery(criteria).list();

        session.close();
        return employees;
    }

    @Override
    public Employee findByEmail(String email) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "from Employee where email like :email";
        Employee employee = session.createQuery(query, Employee.class)
                .setParameter(("email"), "%" + email + "%")
                .getSingleResult();

        session.close();
        return employee;
    }

    @Override
    public Employee findByEmailCriteria(String email) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);

        Root<Employee> root = criteria.from(Employee.class);
        Predicate filter = builder.equal(root.get("email"), email);
        criteria.select(root).where(filter);
        Employee employee = session.createQuery(criteria).getSingleResult();

        session.close();
        return employee;
    }

    @Override
    public List<Employee> findByAge(Integer age) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Employee> query = session.createQuery("FROM Employee WHERE age = :age", Employee.class);
        query.setParameter("age", age);
        List<Employee> employees = query.list();

        session.close();
        return employees;
    }

    @Override
    public List<Employee> findByAgeCriteria(Integer age) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);

        Root<Employee> root = criteria.from(Employee.class);
        Predicate filter = builder.equal(root.get("age"), age);
        criteria.select(root).where(filter);
        List<Employee> employees = session.createQuery(criteria).list();

        session.close();
        return employees;
    }

    @Override
    public List<Employee> findBySalary(Double salary) {
        return null;
    }

    @Override
    public List<Employee> findBySalaryCriteria(Double salary) {
        return null;
    }

    @Override
    public List<Employee> findByMarriage(Boolean married) {
        return null;
    }

    @Override
    public List<Employee> findByMarriageCriteria(Boolean married) {
        return null;
    }

    @Override
    public Employee createEmployee(Employee employee) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(employee);
            session.getTransaction().commit();
        }catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        session.close();
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.merge(employee);
            session.getTransaction().commit();
        }catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return employee;
    }

    @Override
    public boolean deleteById(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Employee employee = this.findById(id);
            session.remove(employee);
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
