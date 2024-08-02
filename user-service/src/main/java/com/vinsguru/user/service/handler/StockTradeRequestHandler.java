package com.vinsguru.user.service.handler;

import com.vinsguru.common.Ticker;
import com.vinsguru.user.StockTradeRequest;
import com.vinsguru.user.StockTradeResponse;
import com.vinsguru.user.UserInformation;
import com.vinsguru.user.UserInformationRequest;
import com.vinsguru.user.exceptions.InsufficientBalanceException;
import com.vinsguru.user.exceptions.InsufficientSharesException;
import com.vinsguru.user.exceptions.UnknownTickerException;
import com.vinsguru.user.exceptions.UnknownUserException;
import com.vinsguru.user.repository.PortfolioRepository;
import com.vinsguru.user.repository.UserRepository;
import com.vinsguru.user.util.EntityMessageMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StockTradeRequestHandler {

    private UserRepository userRepository;
    private PortfolioRepository portfolioRepository;

    public StockTradeRequestHandler(UserRepository userRepository, PortfolioRepository portfolioRepository) {
        this.userRepository = userRepository;
        this.portfolioRepository = portfolioRepository;
    }

    @Transactional
    public StockTradeResponse buyStock(StockTradeRequest request){
        //validate
        this.validateTicker(request.getTicker());

        var user = this.userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UnknownUserException(request.getUserId()));

        var totalPrice = request.getQuantity() * request.getPrice();
        this.validateUserBalance(request.getUserId(), user.getBalance(), totalPrice);

        //deduct balance
        user.setBalance(user.getBalance() - totalPrice);

        //update portfolio items
        this.portfolioRepository.findAllByUserIdAndTicker(request.getUserId(), request.getTicker())
                .ifPresentOrElse(
                        e -> e.setQuantity(e.getQuantity() + request.getQuantity()),
                        () -> this.portfolioRepository.save(EntityMessageMapper.toPortfolioItem(request))
                );

        return EntityMessageMapper.toStockTradeResponse(request, user.getBalance());
    }

    @Transactional
    public StockTradeResponse sellStock(StockTradeRequest request){
        //validate
        this.validateTicker(request.getTicker());

        var user = this.userRepository.findById(request.getUserId())
                                      .orElseThrow(() -> new UnknownUserException(request.getUserId()));

        var portfolioItem = this.portfolioRepository.findAllByUserIdAndTicker(request.getUserId(), request.getTicker())
                                                    .filter(e -> e.getQuantity() >= request.getQuantity())
                                                    .orElseThrow(() -> new InsufficientSharesException(request.getUserId()));

        //add balance
        var totalPrice = request.getQuantity() * request.getPrice();
        user.setBalance(user.getBalance() + totalPrice);

        //update portfolio items
        portfolioItem.setQuantity(portfolioItem.getQuantity() - request.getQuantity());

        //
        return EntityMessageMapper.toStockTradeResponse(request, user.getBalance());
    }

    private void validateTicker(Ticker ticker) {
        if (Ticker.UNKNOWN.equals(ticker)) {
            throw new UnknownTickerException();
        }
    }

    private void validateUserBalance(Integer userId, Integer userBalance, Integer totalPrice) {
        if (totalPrice > userBalance) {
            throw new InsufficientBalanceException(userId);
        }
    }
}
