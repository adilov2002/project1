package practice.springboot.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.springboot.demo.entities.Cars;
import practice.springboot.demo.reps.CarsRepository;
import practice.springboot.demo.services.CarsService;

import java.util.List;

@Service
public class CarsServiceImpl implements CarsService {

    @Autowired
    private CarsRepository carsRepository;

    @Override
    public Cars addCar(Cars car) {
        return carsRepository.save(car);
    }

    @Override
    public Cars saveCar(Cars car) {
        return carsRepository.save(car);
    }

    @Override
    public void deleteCar(Cars car) {
        carsRepository.delete(car);
    }

    @Override
    public List<Cars> listCars() {
        return carsRepository.findAll();
    }

    @Override
    public Cars getCar(Long id) {
        return carsRepository.getOne(id);
    }
}
