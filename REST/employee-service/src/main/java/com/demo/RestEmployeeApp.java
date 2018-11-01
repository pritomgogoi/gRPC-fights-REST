package com.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class RestEmployeeApp {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public Employee lookUpEmployee() {
        log.info("Request on employee endpoint");
        final Employee employee = new Employee();

        final Address address = restTemplate.getForObject("http://localhost:8082/address", Address.class);
        employee.setName("Pritom Gogoi");
        employee.setDepartment("Developer Experience");
        employee.setAddress(address);

        return employee;
    }

    public static void main(String[] args)  {
      SpringApplication.run(RestEmployeeApp.class, args);
    }
}
