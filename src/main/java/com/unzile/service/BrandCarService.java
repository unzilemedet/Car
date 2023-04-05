package com.unzile.service;

import com.unzile.repository.IBrandCarRepository;
import com.unzile.repository.entity.BrandCar;
import com.unzile.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandCarService extends ServiceManager<BrandCar,Long> {
    private final IBrandCarRepository repository;
    public BrandCarService (IBrandCarRepository repository){
        super(repository);
        this.repository = repository;

    }
    public void save(Long carid,Long brandid){
        save(BrandCar.builder()
                .carid(carid)
                .brandid(brandid)
                .build());
    }

    public List<Long> getAllByCarid(Long carid){
        return repository.getAllByCarid(carid);
    }

}
