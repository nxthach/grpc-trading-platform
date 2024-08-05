package com.vinsguru.aggregator.controller;

import com.google.common.util.concurrent.Uninterruptibles;
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

    @GetMapping(value = "updates", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter priceUpdates(){
        SseEmitter emitter = new SseEmitter();

        Thread.ofVirtual().start(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    emitter.send("Data - " + i);
                    Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            emitter.complete();
        });

        return emitter;
    }
}
