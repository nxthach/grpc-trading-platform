package com.vinsguru.user.service;

import com.vinsguru.user.*;
import com.vinsguru.user.service.handler.StockTradeRequestHandler;
import com.vinsguru.user.service.handler.UserInformationRequestHandler;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class UserService extends UserServiceGrpc.UserServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserInformationRequestHandler userRequestHandler;
    private final StockTradeRequestHandler stockTradeRequestHandler;

    public UserService(UserInformationRequestHandler userRequestHandler,
                       StockTradeRequestHandler stockTradeRequestHandler) {
        this.userRequestHandler = userRequestHandler;
        this.stockTradeRequestHandler = stockTradeRequestHandler;
    }

    @Override
    public void getUserInformation(UserInformationRequest request, StreamObserver<UserInformation> responseObserver) {
        log.info("user information for id {}", request.getUserId());
        var userInformation = this.userRequestHandler.getUserInformation(request);

        responseObserver.onNext(userInformation);
        responseObserver.onCompleted();
    }

    @Override
    public void tradeStock(StockTradeRequest request, StreamObserver<StockTradeResponse> responseObserver) {
        log.info("{}", request);
        var response = TradeAction.SELL.equals(request.getAction())
                ? this.stockTradeRequestHandler.sellStock(request)
                : this.stockTradeRequestHandler.buyStock(request);

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
