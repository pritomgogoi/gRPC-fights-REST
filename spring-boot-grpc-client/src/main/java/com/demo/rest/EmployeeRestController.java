package com.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployeeRestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/employee")
    public Employee getEmployee(){
    final Employee employee = new Employee();

    final Address address = restTemplate.getForObject("http://localhost:9081/address", Address.class);

    employee.setName("Pritom Gogoi");
    employee.setAddress(address);

    return employee;
    }
}
