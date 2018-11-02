package com.demo.grpc;

import com.netflix.discovery.EurekaClientConfig;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.exampledriven.grpc.services.AddressResponse;
import org.exampledriven.grpc.services.AddressServiceGrpc;
import org.exampledriven.grpc.services.EmployeeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AddressGrpcClient {

    @Autowired
    private EurekaClientConfig eurekaClientConfig;

    private Logger logger = LoggerFactory.getLogger(AddressGrpcClient.class);

    private AddressServiceGrpc.AddressServiceBlockingStub addressServiceBlockingStub;

    public AddressResponse findAddress(String employeeId) {
        final AddressResponse addressResponse = addressServiceBlockingStub.findAddress(EmployeeRequest.newBuilder().setId(employeeId).build());
        logger.info("Client receiving from gRPC server");
        return addressResponse;
    }

    @PostConstruct
    private void initializeClient() {

        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 7565)
                .usePlaintext(true)
                .build();
        addressServiceBlockingStub = AddressServiceGrpc.newBlockingStub(managedChannel);

    }
}
