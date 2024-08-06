package com.vinsguru.aggregator.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vinsguru.aggregator.dto.PriceUpdateDto;
import com.vinsguru.aggregator.tests.mockservice.StockMockService;
import com.vinsguru.aggregator.tests.mockservice.UserMockService;
import com.vinsguru.user.StockTradeRequest;
import com.vinsguru.user.StockTradeResponse;
import com.vinsguru.user.TradeAction;
import com.vinsguru.user.UserInformation;
import net.devh.boot.grpc.server.service.GrpcService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.ResponseExtractor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

import static com.vinsguru.common.Ticker.AMAZON;
import static org.junit.jupiter.api.Assertions.*;

@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
public class StockUpdatesTest {

    private static final Logger log = LoggerFactory.getLogger(StockUpdatesTest.class);

    private static final String STOCK_UPDATES_ENDPOINT = "http://localhost:%d/stock/updates";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void stockUpdatesTest(){
        var response = this.restTemplate.execute(
                STOCK_UPDATES_ENDPOINT.formatted(port),
                HttpMethod.GET,
                null,
                (clientResponse) -> {
                    var list = new ArrayList<PriceUpdateDto>();
                    try (var reader = new BufferedReader(new InputStreamReader(clientResponse.getBody()))) {
                        String line;
                        while (Objects.nonNull(line = reader.readLine())) {
                            if(!line.isEmpty()){
                                log.info("{}", line);
                                var dto = mapper.readValue(line.substring("data:".length()), PriceUpdateDto.class);
                                list.add(dto);
                            }
                        }
                    }catch (Exception e){
                        log.error("Streaming error", e);
                    }

                    return list;
                }
        );

        assertEquals(5, response.size());
        assertEquals(AMAZON.toString(), response.getFirst().ticker());
        assertEquals(1, response.getFirst().price());
    }


    @TestConfiguration
    static class TestConfig{

        @GrpcService
        public StockMockService stockMockService(){
            return new StockMockService();
        }
    }
}
