package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CarServiceImpl implements ProductService<Car>{
    @Autowired
    private CarRepository carRepository;

    @Override
    public Car create(Car car) {
        // TODO Auto-generated method stub
        carRepository.create(car);
        return car;
    }

    @Override
    public List<Car> findAll() {
        Iterator<Car> carIterator = carRepository.findAll();
        List<Car> allCar = new ArrayList<Car>();
        carIterator.forEachRemaining(allCar::add);
        return allCar;
    }

    @Override
    public Car find(String carId) {
        Car car = carRepository.find(carId);
        return car;
    }

    @Override
    public Car update(String carId, Car car) {
        // TODO Auto-generated method stub
        return carRepository.update(carId, car);
    }

    @Override
    public void delete(String carId) {
        // TODO Auto-generated method stub
        carRepository.delete(carId);
    }
}
