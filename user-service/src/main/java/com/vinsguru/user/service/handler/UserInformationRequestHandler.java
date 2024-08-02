package com.vinsguru.user.service.handler;

import com.vinsguru.user.UserInformation;
import com.vinsguru.user.UserInformationRequest;
import com.vinsguru.user.exceptions.UnknownUserException;
import com.vinsguru.user.repository.PortfolioRepository;
import com.vinsguru.user.repository.UserRepository;
import com.vinsguru.user.util.EntityMessageMapper;
import org.springframework.stereotype.Service;

@Service
public class UserInformationRequestHandler {

    private UserRepository userRepository;
    private PortfolioRepository portfolioRepository;

    public UserInformationRequestHandler(UserRepository userRepository, PortfolioRepository portfolioRepository) {
        this.userRepository = userRepository;
        this.portfolioRepository = portfolioRepository;
    }

    public UserInformation getUserInformation(UserInformationRequest request){
        var user = this.userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UnknownUserException(request.getUserId()));

        var portfolioItems = this.portfolioRepository.findAllByUserId(request.getUserId());

        return EntityMessageMapper.toUserInformation(user, portfolioItems);
    }
}
