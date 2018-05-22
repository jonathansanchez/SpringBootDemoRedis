package com.example.redis.demo.Controller;

import com.example.redis.demo.Application.Service.SaveCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    private SaveCustomer saveCustomerService;

    //Dependency Injection Constructor
    @Autowired
    public CustomerController(SaveCustomer saveCustomerService) {
        this.saveCustomerService = saveCustomerService;
    }
}
