package org.example.dao;

import org.example.entities.Employee;
import org.example.entities.Location;

import java.util.List;

public interface LocationDAO {

    /**
     * Devuelve una lista de todas las locaciones.
     * HQL query
     * @return Location List.
     */
    List<Location> findAll();

    /**
     * Devuelve una lista de todos los empleados.
     * Criteria query
     * @return Employee List.
     */
    List<Location> findAllCriteria();

    /**
     * Busca empleado por ID.
     * @param id
     * @return Location by ID.
     */
    Location findById(Long id);

    /**
     * Busca empleado por ID by Criteria.
     * @param id
     * @return Employee by ID Criteria.
     */
    Location findByIdCriteria(Long id);

    /***
     * Crea una locacion insertandolo en la db de la correspondiente tabla.
     * @param location
     * @return
     */
    Location createLocation(Location location);

    /***
     * Actualiza un registro existente en la db de la correspondiente tabla.
     * @param location
     * @return
     */
    Location updateLocation(Location location);

    /***
     * Borrar un registro en la db de la correspondiente tabla.
     * @param id
     * @return (0/1)
     */
    boolean deleteLocationById(Long id);

    /**
     * Busca todas las calles por nombre.
     * @param StreetName
     * @return Location List by StreetName.
     */
    List<Location> findByStreetName(String StreetName);

    /**
     *  Busca todas las calles por nombre by Criteria.
     * @param StreetName
     * @return Location List by StreetName by Criteria.
     */
    List<Location> findByStreetNameCriteria(String StreetName);

    /**
     * Busca todos los codigos postales por nombre.
     * @param ZIPCode
     * @return Location List by ZIPCode.
     */
    List<Location> findByZIPCode(String ZIPCode);

    /**
     *  Busca todos los codigos postales por nombre by Criteria.
     * @param ZIPCode
     * @return Location List by ZIPCode by Criteria.
     */
    List<Location> findByZIPCodeCriteria(String ZIPCode);

    /**
     * Busca todas las cuidades por nombre.
     * @param cityName
     * @return Location List by cityName.
     */
    List<Location> findByCityName(String cityName);

    /**
     *  Busca todas las cuidades por nombre by Criteria.
     * @param cityName
     * @return Location List by cityName by Criteria.
     */
    List<Location> findByCityNameCriteria(String cityName);

    /**
     * Busca todos los paises por nombre.
     * @param countryName
     * @return Location List by countryName.
     */
    List<Location> findByCountryName(String countryName);

    /**
     *  Busca todos los paises por nombre by Criteria.
     * @param countryName
     * @return Location List by countryName by Criteria.
     */
    List<Location> findByCountryNameCriteria(String countryName);
}
