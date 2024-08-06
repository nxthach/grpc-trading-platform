package com.vinsguru.aggregator.controller;

import com.google.common.util.concurrent.Uninterruptibles;
import com.vinsguru.aggregator.service.PriceUpdateListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("stock")
public class StockController {

    @Autowired
    PriceUpdateListener listener;

    @GetMapping(value = "updates", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter priceUpdates(){
        return listener.createSseEmitter();
    }
}
