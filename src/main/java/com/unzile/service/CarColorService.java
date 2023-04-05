package com.unzile.service;

import com.unzile.exception.CarException;
import com.unzile.exception.ErrorType;
import com.unzile.repository.ICarColorRepository;
import com.unzile.repository.entity.CarColor;
import com.unzile.repository.entity.Color;
import com.unzile.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarColorService extends ServiceManager<CarColor,Long> {
    private final ICarColorRepository carColorRepository;
   private final ColorService colorService;
    public CarColorService(ICarColorRepository carColorRepository,
                           ColorService colorService){
        super(carColorRepository);
        this.carColorRepository = carColorRepository;
        this.colorService = colorService;
    }

    public void save(Long carid,Long colorid){
        Optional<Color> color = colorService.findById(colorid);
        if(color.isEmpty()){
            throw new CarException(ErrorType.ERROR);
        }else {
            save(CarColor.builder()
                    .carid(carid)
                    .colorid(colorid)
                    .build());
        }
    }
}
