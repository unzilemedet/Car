package com.unzile.controller;

import com.unzile.dto.request.SaveRentalRequestDto;
import com.unzile.repository.entity.Rental;
import com.unzile.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.unzile.constants.EndPointList.*;

@RestController
@RequestMapping(RENTAL)
@RequiredArgsConstructor
public class RentalController {
    private  final RentalService rentalService;
    @PostMapping(SAVE)
    public ResponseEntity<Rental> save(@RequestBody  SaveRentalRequestDto dto) {
        return ResponseEntity.ok(rentalService.save(dto));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Rental>> findAll() {
        return ResponseEntity.ok(rentalService.findAll());
    }
}
