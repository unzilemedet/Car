package com.unzile.dto.response;

import com.unzile.repository.entity.Brand;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class FindByArabaAdiResponseDto {
    String arabaAdi;
    List<Brand> brandList;
}
