package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class RestAddressApp {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/address", method = RequestMethod.GET)
    public Address lookUpAddress() {
        log.info("Request on address endpoint");

        final Address address = new Address();
        address.setStreetName("Bluxome St");
        address.setCity("San Francisco");
        address.setState("California");

        return address;
    }

    public static void main(String[] args) {
        SpringApplication.run(RestAddressApp.class, args);
    }

}
