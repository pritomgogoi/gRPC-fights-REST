package com.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressRestController {

    @GetMapping("/address/{id}")
    public Address getAddress(@PathVariable String id) {

        final Address address = new Address();
        if (id.equals("1")) {
            address.setCity("San Francisco");
            address.setState("California");
        }
        return address;
    }
}
