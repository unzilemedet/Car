package com.unzile.controller;

import com.unzile.dto.request.SaveBrandRequestDto;
import com.unzile.dto.response.FindByArabaAdiResponseDto;
import com.unzile.repository.entity.Brand;
import com.unzile.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

import static com.unzile.constants.EndPointList.*;

@RestController
@RequestMapping(BRAND)
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @PostMapping(SAVE)
    public ResponseEntity<Brand> save(@RequestBody @Valid SaveBrandRequestDto dto) {
        return ResponseEntity.ok(brandService.save(dto));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Brand>> findAll() {
        return ResponseEntity.ok(brandService.findAll());
    }

    @GetMapping(FIND_BY_ARABAADI)
    public ResponseEntity<List<FindByArabaAdiResponseDto>> findByArabaAdi(String arabaAdi){
        List<FindByArabaAdiResponseDto> result = brandService.findByArabaAdi(arabaAdi);
        return ResponseEntity.ok(result);
    }
}