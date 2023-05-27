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
     * @param Id
     * @return Employee by ID.
     */
    Employee findById(Long Id);

    /**
     * Busca todos los empleados por nombre.
     * @param firstName
     * @return Employee List by Firs tName.
     */
    List<Employee> findByFirstName(String firstName);

    /**
     * Busca todos los empleados por apellido.
     * @param lastName
     * @return Employee List by Last Name.
     */
    List<Employee> findByLastName(String lastName);

    /**
     * Busca empleado por email.
     * @param email
     * @return Employee by Email.
     */
    Employee findByEmail(String email);

    /**
     * Busca todos los empleados por edad.
     * @param age
     * @return Employee List by Age.
     */
    List<Employee> findByAge(Integer age);

    /**
     * Busca todos los empleados por salario.
     * @param salary
     * @return Employee List by Salary.
     */
    List<Employee> findByAge(Double salary);

    /**
     * Busca todos los empleados por estado civil.
     * @param married
     * @return Employee List by Married(0/1).
     */
    List<Employee> findByAge(Boolean married);


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
