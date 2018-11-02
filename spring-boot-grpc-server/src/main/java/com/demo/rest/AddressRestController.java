package com.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressRestController {

    @RequestMapping("/address")
    public Address getAddress(){
        final Address address = new Address();
        address.setCity("San Francisco");
        address.setState("California");
        return address;
    }
}
