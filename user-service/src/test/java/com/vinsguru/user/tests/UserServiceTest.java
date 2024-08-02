package com.vinsguru.user.tests;

import com.vinsguru.common.Ticker;
import com.vinsguru.user.StockTradeRequest;
import com.vinsguru.user.TradeAction;
import com.vinsguru.user.UserInformationRequest;
import com.vinsguru.user.UserServiceGrpc;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserServiceTest {

    @GrpcClient("user-service")
    private UserServiceGrpc.UserServiceBlockingStub stub;

    @Test
    public void getGetUserInformation() {
        var response = this.stub.getUserInformation(
                UserInformationRequest.newBuilder()
                        .setUserId(1)
                        .build());

        assertEquals(10_000, response.getBalance());
        assertEquals("Sam", response.getName());
        assertTrue(response.getHoldingsList().isEmpty());

    }

    @Test
    public void getGetUserInformationWhenUnknownUser() {

        var ex = assertThrows(StatusRuntimeException.class,
                () -> {
                    this.stub.getUserInformation(
                            UserInformationRequest.newBuilder()
                                    .setUserId(10)
                                    .build());
                });

        assertEquals(Status.Code.NOT_FOUND, ex.getStatus().getCode());

    }

    @Test
    public void buyStockWhenUnknownTicker() {

        var ex = assertThrows(StatusRuntimeException.class,
                () -> {
                    this.stub.tradeStock(StockTradeRequest.newBuilder()
                            .setUserId(1)
                            .setAction(TradeAction.BUY)
                            .setTicker(Ticker.UNKNOWN)
                            .setQuantity(1)
                            .setPrice(10)
                            .build());
                });

        assertEquals(Status.Code.INVALID_ARGUMENT, ex.getStatus().getCode());

    }

    @Test
    public void buyStockWhenInsufficientBalance() {

        var ex = assertThrows(StatusRuntimeException.class,
                () -> {
                    this.stub.tradeStock(StockTradeRequest.newBuilder()
                            .setUserId(1)
                            .setAction(TradeAction.BUY)
                            .setTicker(Ticker.AMAZON)
                            .setQuantity(1)
                            .setPrice(50_000)
                            .build());
                });

        assertEquals(Status.Code.FAILED_PRECONDITION, ex.getStatus().getCode());

    }

    @Test
    public void sellStockWhenInsufficientShares() {

        var ex = assertThrows(StatusRuntimeException.class,
                () -> {
                    this.stub.tradeStock(StockTradeRequest.newBuilder()
                            .setUserId(1)
                            .setAction(TradeAction.SELL)
                            .setTicker(Ticker.AMAZON)
                            .setQuantity(1)
                            .setPrice(10)
                            .build());
                });

        assertEquals(Status.Code.FAILED_PRECONDITION, ex.getStatus().getCode());

    }


    @Test
    public void tradeStockIncludeBuyAndSell() {
        //buy
        var buyRequest = StockTradeRequest.newBuilder()
                .setUserId(1)
                .setAction(TradeAction.BUY)
                .setTicker(Ticker.AMAZON)
                .setQuantity(5)
                .setPrice(100)
                .build();

        var buyResponse = this.stub.tradeStock(buyRequest);

        //validate balance after buy some
        assertEquals(9_500, buyResponse.getBalance());

        //check the holding
        var userResponse = this.stub.getUserInformation(
                UserInformationRequest.newBuilder()
                        .setUserId(1)
                        .build());

        assertEquals(1, userResponse.getHoldingsCount());
        assertEquals(Ticker.AMAZON, userResponse.getHoldingsList().getFirst().getTicker());

        //sell
        var sellRequest = StockTradeRequest.newBuilder()
                .setUserId(1)
                .setAction(TradeAction.SELL)
                .setTicker(Ticker.AMAZON)
                .setQuantity(1)
                .setPrice(110)
                .build();

        var sellResponse = this.stub.tradeStock(sellRequest);

        //validate balance after sell some
        assertEquals(9_500 + 110, sellResponse.getBalance());


    }

    ;


}


