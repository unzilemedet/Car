package com.unzile.mapper;

import com.unzile.dto.request.SaveColorRequestDto;
import com.unzile.repository.entity.Color;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IColorMapper {
    IColorMapper INSTANCE = Mappers.getMapper(IColorMapper.class);
    Color toColor(final SaveColorRequestDto dto);
}
