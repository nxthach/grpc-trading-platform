package com.vinsguru.aggregator.service;

import com.vinsguru.stock.StockPriceRequest;
import com.vinsguru.stock.StockServiceGrpc;
import com.vinsguru.user.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class TradeService {

    @GrpcClient("user-service")
    private UserServiceGrpc.UserServiceBlockingStub userClient;

    @GrpcClient("stock-service")
    private StockServiceGrpc.StockServiceBlockingStub stockClient;

    public StockTradeResponse trade(StockTradeRequest request) {

        var priceResponse = this.stockClient.getStockPrice(
                StockPriceRequest.newBuilder()
                        .setTicker(request.getTicker())
                        .build());

        var tradeRequest = request.toBuilder()
                .setPrice(priceResponse.getPrice())
                .build();

        return this.userClient.tradeStock(tradeRequest);
    }

}
