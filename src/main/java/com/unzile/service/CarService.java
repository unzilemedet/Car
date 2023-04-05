package com.unzile.service;

import com.unzile.dto.request.SaveCarRequestDto;
import com.unzile.exception.CarException;
import com.unzile.exception.ErrorType;
import com.unzile.mapper.ICarMapper;
import com.unzile.repository.ICarRepository;
import com.unzile.repository.entity.Car;
import com.unzile.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService extends ServiceManager<Car,Long> {
    private final ICarRepository carRepository;
    private final CarColorService carColorService;


    public CarService(ICarRepository carRepository, CarColorService carColorService) {
        super(carRepository);
        this.carRepository = carRepository;
        this.carColorService = carColorService;
    }

    public Car save(SaveCarRequestDto dto) {
        return save(ICarMapper.INSTANCE.toCar(dto));
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    //public List<Car> searchCars(String name) {
    //    return carRepository.findAllByNameContainingIgnoreCase(name);
  //  }

    public List<Car> findAllByAdContaining(String name) {
        return carRepository.findAllByAdContaining(name);

    }

    public List<Car> findCarsByColor(Long colorId) {
        List<Car> carList = carRepository.findCarsByColor(colorId);
        if (carList.isEmpty()) {
            throw new CarException(ErrorType.ERROR);
        }
        return carList;
    }
}