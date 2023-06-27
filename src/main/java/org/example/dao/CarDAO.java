package org.example.dao;


import org.example.entities.Car;
import org.example.entities.Employee;

import java.util.List;

public interface CarDAO {

    Car findCarById(Long id);

    Car createCar(Car car);

    Car updateCar(Car car);

    boolean deleteCarById(Long id);




}
