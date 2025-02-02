package com.vinsguru.user.repository;

import com.vinsguru.common.Ticker;
import com.vinsguru.user.entity.PortfolioItem;
import com.vinsguru.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PortfolioRepository extends CrudRepository<PortfolioItem, Integer> {

    List<PortfolioItem> findAllByUserId(Integer userId);
    Optional<PortfolioItem> findAllByUserIdAndTicker(Integer userId, Ticker ticker);
}
