package com.unzile.service;

import com.unzile.dto.request.SaveRentalRequestDto;

import com.unzile.mapper.IRentalMapper;
import com.unzile.repository.IRentalRepository;
import com.unzile.repository.entity.Brand;
import com.unzile.repository.entity.Rental;
import com.unzile.utility.ServiceManager;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService extends ServiceManager<Rental,Long> {
    private final IRentalRepository rentalRepository;
    public RentalService(IRentalRepository rentalRepository) {
        super(rentalRepository);
        this.rentalRepository= rentalRepository;
    }
    public Rental save(SaveRentalRequestDto dto){
        return save(IRentalMapper.INSTANCE.toRental(dto));
    }
    public List<Rental> findAll(){
        return rentalRepository.findAll();
    }
}
