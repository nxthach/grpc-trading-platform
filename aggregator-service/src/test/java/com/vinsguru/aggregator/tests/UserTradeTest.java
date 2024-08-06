package com.vinsguru.aggregator.tests;

import com.vinsguru.aggregator.tests.mockservice.StockMockService;
import com.vinsguru.aggregator.tests.mockservice.UserMockService;
import com.vinsguru.user.StockTradeRequest;
import com.vinsguru.user.StockTradeResponse;
import com.vinsguru.user.TradeAction;
import com.vinsguru.user.UserInformation;
import net.devh.boot.grpc.server.service.GrpcService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

import static com.vinsguru.common.Ticker.AMAZON;
import static org.junit.jupiter.api.Assertions.*;

@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserTradeTest {

    private static final String USER_INFORMATION_ENDPOINT = "http://localhost:%d/user/%d";
    private static final String TRADE_ENDPOINT = "http://localhost:%d/trade";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void userInformationTest(){
        var url = USER_INFORMATION_ENDPOINT.formatted(port, 1);
        var response = this.restTemplate.getForEntity(url, UserInformation.class);

        assertEquals(200, response.getStatusCode().value());

        //
        var user = response.getBody();

        assertNotNull(user);
        assertEquals(1, user.getUserId());
        assertEquals("integration-test", user.getName());
        assertEquals(100, user.getBalance());

    }

    @Test
    public void unknownUserTest(){
        var url = USER_INFORMATION_ENDPOINT.formatted(port, 2);
        var response = this.restTemplate.getForEntity(url, UserInformation.class);

        assertEquals(404, response.getStatusCode().value());

        //
        var user = response.getBody();

        assertNull(user);
    }

    @Test
    public void tradeTest(){
        var tradeRequest = StockTradeRequest.newBuilder()
                .setUserId(1)
                .setPrice(10)
                .setTicker(AMAZON)
                .setAction(TradeAction.BUY)
                .setQuantity(2)
                .build();

        var url = TRADE_ENDPOINT.formatted(port);
        var response = this.restTemplate.postForEntity(url, tradeRequest, StockTradeResponse.class);

        //
        assertEquals(200, response.getStatusCode().value());

        //
        var tradeResponse = response.getBody();
        assertNotNull(tradeResponse);
        assertEquals(AMAZON, tradeResponse.getTicker());
        assertEquals(1, tradeResponse.getUserId());
        assertEquals(15, tradeResponse.getPrice());
        assertEquals(1000, tradeResponse.getTotalPrice());
        assertEquals(0, tradeResponse.getBalance());

    }


    @TestConfiguration
    static class TestConfig{

        @GrpcService
        public UserMockService userMockService(){
            return new UserMockService();
        }

        @GrpcService
        public StockMockService stockMockService(){
            return new StockMockService();
        }
    }
}
