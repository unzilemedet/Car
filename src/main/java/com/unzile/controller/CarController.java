package com.unzile.controller;

import com.unzile.dto.request.SaveCarRequestDto;
import com.unzile.repository.entity.Car;
import com.unzile.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.unzile.constants.EndPointList.*;

@RestController
@RequestMapping(CAR)
@RequiredArgsConstructor
public class CarController{
    private final CarService carService;
    @PostMapping(SAVE)
    public ResponseEntity<Car> save(@RequestBody SaveCarRequestDto dto){
        return ResponseEntity.ok(carService.save(dto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Car>> findAll(){
        return ResponseEntity.ok(carService.findAll());
    }

   @GetMapping(FIND_CAR_COLOR_ID +"/{colorid}")
   public ResponseEntity<List<Car>> findCarsByColor(@PathVariable Long colorid){
       return ResponseEntity.ok(carService.findCarsByColor(colorid));
   }


}
