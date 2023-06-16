package org.example.dao;

import org.example.entities.Employee;

import java.util.List;

public interface EmployeeDAO {

    /**
     * Devuelve una lista de todos los empleados.
     * HQL query
     * @return Employee List.
     */
    List<Employee> findAll();

    /**
     * Devuelve una lista de todos los empleados.
     * Criteria query
     * @return Employee List.
     */
    List<Employee> findAllCriteria();

    /**
     * Busca empleado por ID.
     * @param id
     * @return Employee by ID.
     */
    Employee findById(Long id);

    /**
     * Busca empleado por ID y sus relaciones, carga anticipada de datos eager loading(carga ansiosa).
     * @param id
     * @return Employee by ID.
     */
    Employee findByIdEager(Long id);

    /**
     * Busca empleado por ID by Criteria.
     * @param id
     * @return Employee by ID Criteria.
     */
    Employee findByIdCriteria(Long id);

    /**
     * Busca todos los empleados por nombre.
     * @param firstName
     * @return Employee List by Firs tName.
     */
    List<Employee> findByFirstName(String firstName);

    /**
     * Busca todos los empleados por nombre by Criteria.
     * @param firstName
     * @return Employee List by First Name bby Criteria.
     */
    List<Employee> findByFirstNameCriteria(String firstName);


    /**
     * Busca todos los empleados por apellido.
     * @param lastName
     * @return Employee List by Last Name.
     */
    List<Employee> findByLastName(String lastName);

    /**
     * Busca todos los empleados por apellido by Criteria.
     * @param lastName
     * @return Employee List by Last Name by Criteria.
     */
    List<Employee> findByLastNameCriteria(String lastName);

    /**
     * Busca empleado por email.
     * @param email
     * @return Employee by Email.
     */
    Employee findByEmail(String email);

    /**
     * Busca empleado por email by criteria.
     * @param email
     * @return Employee Email by criteria.
     */
    Employee findByEmailCriteria(String email);

    /**
     * Busca todos los empleados por edad.
     * @param age
     * @return Employee List by Age.
     */
    List<Employee> findByAge(Integer age);

    /**
     * Busca todos los empleados por edad by Criteria.
     * @param age
     * @return Employee List by Age by Criteria.
     */
    List<Employee> findByAgeCriteria(Integer age);

    /**
     * Busca todos los empleados greater than :age.
     * @param age
     * @return Employee List of Age greater than :age.
     */
    List<Employee> findByAgeGT(Integer age);

    /**
     * Busca todos los empleados greater than :age by Criteria.
     * @param age
     * @return Employee List greater than :age by Criteria.
     */
    List<Employee> findByAgeGTCriteria(Integer age);

    /**
     * Busca todos los empleados por salario.
     * @param min
     * @param max
     * @return Employee List by Salary.
     */
    List<Employee> findByBTSalary(Double min,Double max);

    /**
     * Busca todos los empleados por salario by Criteria.
     * @param min
     * @param max
     * @return Employee List by Salary by Criteria.
     */
    List<Employee> findByBTSalaryCriteria(Double min, Double max);

    /**
     * Busca todos los empleados por estado civil.
     * @param married
     * @return Employee List by Married(0/1).
     */
    List<Employee> findByMarriage(Boolean married);

    /**
     * Busca todos los empleados por estado civil by Criteria.
     * @param married
     * @return Employee List by Married(0/1) by Criteria.
     */
    List<Employee> findByMarriageCriteria(Boolean married);

    /***
     * Crea un empleado insertandolo en la db de la correspondiente tabla.
     * @param employee
     * @return
     */
    Employee createEmployee(Employee employee);

    /***
     * Actualiza un registro existente en la db de la correspondiente tabla.
     * @param employee
     * @return
     */
    Employee updateEmployee(Employee employee);


    /***
     * Borrar un registro en la db de la correspondiente tabla.
     * @param id
     * @return (0/1)
     */
    boolean deleteById(Long id);

//    boolean deleteAll();

}
