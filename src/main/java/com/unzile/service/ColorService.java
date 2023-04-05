package com.unzile.service;

import com.unzile.dto.request.SaveColorRequestDto;
import com.unzile.exception.CarException;
import com.unzile.exception.ErrorType;
import com.unzile.mapper.IColorMapper;
import com.unzile.repository.IColorRepository;
import com.unzile.repository.entity.Color;
import com.unzile.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColorService extends ServiceManager<Color,Long> {
    private final IColorRepository colorRepository;



    public ColorService(IColorRepository colorRepository){
        super(colorRepository);
        this.colorRepository = colorRepository;
    }
    public void save(SaveColorRequestDto dto){
        Optional<Color> color = colorRepository.findByNameIgnoreCase(dto.getColorname());
        if(color.isEmpty()){
            colorRepository.save(IColorMapper.INSTANCE.toColor(dto));
        }else{
            throw new CarException(ErrorType.BOOK_NOT_FOUND);
        }
    }

}
