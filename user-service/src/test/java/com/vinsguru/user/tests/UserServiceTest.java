package com.vinsguru.user.tests;

import com.vinsguru.user.UserInformationRequest;
import com.vinsguru.user.UserServiceGrpc;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserServiceTest {

    @GrpcClient("user-service")
    private UserServiceGrpc.UserServiceBlockingStub stub;

    @Test
    public void getGetUserInformation(){
        var response = this.stub.getUserInformation(
                UserInformationRequest.newBuilder()
                        .setUserId(1)
                        .build());

        assertEquals(10_000, response.getBalance());
        assertEquals("Sam", response.getName());
        assertTrue(response.getHoldingsList().isEmpty());

    }

    @Test
    public void getGetUserInformationWhenUnknownUser(){

        var ex = assertThrows(StatusRuntimeException.class,
                () -> {
                    this.stub.getUserInformation(
                            UserInformationRequest.newBuilder()
                                    .setUserId(10)
                                    .build());
                });

        assertEquals(Status.Code.NOT_FOUND, ex.getStatus().getCode());

    }


}
