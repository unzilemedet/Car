package com.unzile.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveCarRequestDto {
    private String name;
    private Integer modelYear;
    private Double dailyPrice;
    private String description;
    private Long brandId;
    private List<Long> colorIds;
}
