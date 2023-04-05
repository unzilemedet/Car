package com.unzile.service;

import com.unzile.dto.request.SaveCarRequestDto;
import com.unzile.dto.request.SaveCustomerRequestDto;
import com.unzile.mapper.ICarMapper;
import com.unzile.mapper.ICustomerMapper;
import com.unzile.repository.ICustomerRepository;
import com.unzile.repository.entity.Brand;
import com.unzile.repository.entity.Car;
import com.unzile.repository.entity.Customer;
import com.unzile.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService extends ServiceManager<Customer,Long>{
    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository){
        super(customerRepository);
        this.customerRepository = customerRepository;
    }
    public Customer save(SaveCustomerRequestDto dto){
        return save(ICustomerMapper.INSTANCE.toCustomer(dto));
    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
}
