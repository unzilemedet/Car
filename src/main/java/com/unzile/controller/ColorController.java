package com.unzile.controller;

import com.unzile.dto.request.SaveColorRequestDto;
import com.unzile.repository.entity.Color;
import com.unzile.service.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.unzile.constants.EndPointList.*;

@RestController
@RequestMapping(COLOR)
@RequiredArgsConstructor
public class ColorController {
    private final ColorService colorService;

    @PostMapping(SAVE)
    public ResponseEntity<Void> save(@RequestBody @Valid SaveColorRequestDto dto){
        colorService.save(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Color>> findAll(){
        return ResponseEntity.ok(colorService.findAll());
    }
}
