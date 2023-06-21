package org.example.dao;

import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.*;
import org.example.dto.EmployeeDTO;
import org.example.entities.Employee;
import org.example.entities.EmployeeSeniority;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
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
    public Employee findByIdEager(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Employee> query = session.createQuery("select distinct e from Employee e join fetch e.car where e.id = :id", Employee.class);
        query.setParameter("id", id);
        Employee employee = query.getSingleResultOrNull();

        session.close();
        return employee;
    }

//    @Override
//    public EmployeeDTO findByIdNative(Long id) {
//
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        NativeQuery<EmployeeDTO> query = session.createNativeQuery("SELECT id, email FROM Employee WHERE id = :id", EmployeeDTO.class);
//        query.setParameter("id", id);
//
//        EmployeeDTO employee = query.getSingleResultOrNull();
//
//        session.close();
//        return employee;
//    }

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
        String query = "from Employee where email = :email";
        Employee employee = session.createQuery(query, Employee.class)
                .setParameter(("email"), email)
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
    public List<Employee> findByAgeGT(Integer age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Employee> query = session.createQuery("FROM Employee WHERE age > :age", Employee.class);
        query.setParameter("age", age);
        List<Employee> employees = query.list();

        session.close();
        return employees;
    }

    @Override
    public List<Employee> findByAgeGTCriteria(Integer age) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);

        Root<Employee> root = criteria.from(Employee.class);
        Predicate filter = builder.gt(root.get("age"), age);
        criteria.select(root).where(filter);
        List<Employee> employees = session.createQuery(criteria).list();

        session.close();
        return employees;
    }

    @Override
    public List<Employee> findByBTSalary(Double min, Double max) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Employee> query = session.createQuery("FROM Employee WHERE salary BETWEEN :min AND :max", Employee.class);
        query.setParameter("min", min).setParameter("max", max);
        List<Employee> employees = query.list();

        session.close();
        return employees;
    }

    @Override
    public List<Employee> findByBTSalaryCriteria(Double min, Double max) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);

        Root<Employee> root = criteria.from(Employee.class);
        Predicate filter = builder.between(root.get("salary"), min, max);
        criteria.select(root).where(filter);
        List<Employee> employees = session.createQuery(criteria).list();

        session.close();
        return employees;
    }

    @Override
    public List<Employee> findByMarriage(Boolean isMarried) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "from Employee where married = :isMarried";
        List<Employee> employees = session.createQuery(query, Employee.class)
                .setParameter(("isMarried"), isMarried)
                .list();

        session.close();
        return employees;
    }

    @Override
    public List<Employee> findByMarriageCriteria(Boolean isMarried) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);

        Root<Employee> root = criteria.from(Employee.class);
        Predicate filter = builder.equal(root.get("married"),isMarried);
        criteria.select(root).where(filter);
        List<Employee> employees = session.createQuery(criteria).list();

        session.close();
        return employees;
    }

    @Override
    public List<Employee> findBetweenAgeAndSeniority(Integer minAge, Integer maxAge, EmployeeSeniority seniority) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        String query = "FROM Employee WHERE seniority = :seniority AND age BETWEEN :minAge AND :maxAge";
        List<Employee> employees = session.createQuery(query, Employee.class)
                .setParameter(("seniority"), seniority)
                .setParameter("minAge", minAge)
                .setParameter("maxAge", maxAge)
                .list();

        session.close();
        return employees;
    }

    @Override
    public List<Employee> findBetweenAgeAndSeniorityByCriteria(Integer minAge, Integer maxAge, EmployeeSeniority seniority) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);

        Root<Employee> root = criteria.from(Employee.class);
        Predicate filterByAge = builder.between(root.get("age"),minAge, maxAge);
        Predicate filterByCategory = builder.equal(root.get("seniority"),seniority);
        Predicate filterFilter = builder.and(filterByAge, filterByCategory);
//                               builder.or(filterByAge, filterByCategory);
        criteria.select(root).where(filterFilter);
        List<Employee> employees = session.createQuery(criteria).list();

        session.close();
        return employees;
    }

    @Override
    public Integer findAvgAgeCriteria() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Double> criteria = builder.createQuery(Double.class);

        Root<Employee> root = criteria.from(Employee.class);

        Expression<Double> avg = builder.avg(root.get("age"));
        criteria.select(avg);

        Double averAge = session.createQuery(criteria).getSingleResultOrNull();
        return (int)(Math.round(averAge));
    }

    @Override
    public Employee createEmployee(Employee employee) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(employee);
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
