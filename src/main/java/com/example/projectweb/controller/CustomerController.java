package com.example.projectweb.controller;


import com.example.projectweb.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.projectweb.service.CustomerService;
import reactor.core.publisher.Flux;

import javax.print.attribute.standard.Media;
import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping(value = "/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public List<Customer> getAllCustomers(){
        return customerService.loadAllCustomer();
    }

    @GetMapping(value = "/streams", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomersStreams(){
        return customerService.loadAllCustomerStream();
    }



}
