package practice.springboot.demo.services;

import practice.springboot.demo.entities.Cars;

import java.util.List;

public interface CarsService {

    Cars addCar(Cars car); // adding
    Cars saveCar(Cars car); // saving
    void deleteCar(Cars car); // deleting
    List<Cars> listCars(); // list all cars
    Cars getCar(Long id); // get one car
    List<Cars> searchCars(String name); // searching List of Cars with name like


}
