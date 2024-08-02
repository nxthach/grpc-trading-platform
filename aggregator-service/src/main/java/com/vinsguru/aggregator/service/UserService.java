package com.vinsguru.aggregator.service;

import com.vinsguru.user.UserInformation;
import com.vinsguru.user.UserInformationRequest;
import com.vinsguru.user.UserServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @GrpcClient("user-service")
    private UserServiceGrpc.UserServiceBlockingStub userClient;

    public UserInformation getUserInformation(Integer userId) {
        return this.userClient.getUserInformation(UserInformationRequest.newBuilder()
                .setUserId(userId)
                .build());
    }

}
