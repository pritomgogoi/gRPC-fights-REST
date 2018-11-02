package com.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployeeRestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/rest/employee/{id}")
    public Employee getEmployee(@PathVariable String id) {

        final Employee employee = new Employee();
        employee.setName("Pritom Gogoi");

        final Address address = restTemplate.getForObject("http://localhost:9081/address/" + id, Address.class);
        employee.setAddress(address);

        return employee;
    }
}
