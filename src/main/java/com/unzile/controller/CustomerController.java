package com.unzile.controller;

import com.unzile.dto.request.SaveCustomerRequestDto;
import com.unzile.repository.entity.Customer;
import com.unzile.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.unzile.constants.EndPointList.*;

@RestController
@RequestMapping(CUSTOMER)
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    @PostMapping(SAVE)
    public ResponseEntity<Customer> save(@RequestBody @Valid SaveCustomerRequestDto dto){
        return ResponseEntity.ok(customerService.save(dto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }
}
