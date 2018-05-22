package com.example.redis.demo.Application.Service;

import com.example.redis.demo.domain.Customer.Customer;
import com.example.redis.demo.domain.Customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SaveCustomer")
public class SaveCustomer {

    private CustomerRepository customerRepository;

    //Dependency Injection Constructor
    @Autowired
    public SaveCustomer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public execute(CustomerRequest customerRequest) {
        // Todo: create DTO CustomerRequest Class
        customerRepository.save(
                new Customer(1, "Jack", "Smith")
        );
    }
}
