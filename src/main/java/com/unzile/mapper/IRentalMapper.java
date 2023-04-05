package com.unzile.mapper;

import com.unzile.dto.request.SaveRentalRequestDto;
import com.unzile.repository.entity.Rental;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IRentalMapper {
    IRentalMapper INSTANCE = Mappers.getMapper(IRentalMapper.class);
    Rental toRental(final SaveRentalRequestDto dto);
}
