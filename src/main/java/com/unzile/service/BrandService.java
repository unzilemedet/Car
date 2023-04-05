package com.unzile.service;

import com.unzile.dto.request.SaveBrandRequestDto;
import com.unzile.dto.response.FindByArabaAdiResponseDto;
import com.unzile.mapper.IBrandMapper;
import com.unzile.repository.IBrandRepository;
import com.unzile.repository.entity.Brand;
import com.unzile.repository.entity.Car;
import com.unzile.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BrandService extends ServiceManager<Brand,Long> {
   private  final IBrandRepository brandRepository;
   private final CarService carService;
   private final BrandCarService brandCarService;

    public BrandService(IBrandRepository repostiroy, CarService carService,BrandCarService brandCarService) {
        super(repostiroy);
        this.brandRepository = repostiroy;
        this.carService = carService;
        this.brandCarService =brandCarService;
    }

    public Brand save(SaveBrandRequestDto dto){
        return save(IBrandMapper.INSTANCE.toBrand(dto));
    }
    public List<Brand> findAll(){
        return brandRepository.findAll();
    }


    public  List<FindByArabaAdiResponseDto> findByArabaAdi(String arabaAdi){
        List<FindByArabaAdiResponseDto> result = new ArrayList<>();
        List<Car> carList = carService.findAllByAdContaining(arabaAdi);
        carList.forEach(car->{
            List<Long> branids =brandCarService.getAllByCarid(car.getId());
            List<Brand> brandList = brandRepository.findAllById(branids);
            FindByArabaAdiResponseDto dto = FindByArabaAdiResponseDto.builder()
                    .arabaAdi(car.getName())
                    .brandList(brandList)
                    .build();
            result.add(dto);
        });
        return result;
    }
}