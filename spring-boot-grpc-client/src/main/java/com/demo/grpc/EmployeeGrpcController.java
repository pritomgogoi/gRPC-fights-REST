package com.demo.grpc;

import org.exampledriven.grpc.services.AddressResponse;
import com.demo.rest.Address;
import com.demo.rest.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeGrpcController {

    @Autowired
    private AddressGrpcClient addressGrpcClient;

    @GetMapping("/grpc/employee/{id}")
    public Employee getEmployeeDetails(@PathVariable String id){
        final Employee employee = new Employee();
        employee.setName("Pritom Gogoi");

        final AddressResponse addressResponse = addressGrpcClient.findAddress(id);

        final Address address = new Address();
        address.setState(addressResponse.getState());
        address.setCity(addressResponse.getCity());
        employee.setAddress(address);

        return employee;
    }
}
