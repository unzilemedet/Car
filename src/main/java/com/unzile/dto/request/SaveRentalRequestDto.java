package com.unzile.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveRentalRequestDto {
    private Long rentDate;
    private Long customerId;
    private Long carId;
}
