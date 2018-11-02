package com.demo.grpc;


import io.grpc.stub.StreamObserver;
import org.exampledriven.grpc.services.AddressResponse;
import org.exampledriven.grpc.services.AddressServiceGrpc;
import org.exampledriven.grpc.services.EmployeeRequest;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class AddressGrpcService extends AddressServiceGrpc.AddressServiceImplBase {

    @Override
    public void findAddress(EmployeeRequest employeeRequest, StreamObserver<AddressResponse> responseStreamObserver) {
        System.out.println("Finding address for employee id: " + employeeRequest.getId());

        AddressResponse addressResponse = AddressResponse.newBuilder().setCity("San Francisco").setState("California").build();

        responseStreamObserver.onNext(addressResponse);
        responseStreamObserver.onCompleted();
    }
}