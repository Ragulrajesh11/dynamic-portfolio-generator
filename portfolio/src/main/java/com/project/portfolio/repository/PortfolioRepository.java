package com.project.portfolio.repository;

import com.project.portfolio.model.PortfolioData;
import org.springframework.data.mongodb.repository.MongoRepository;

// Integer-ku badhila String use pandrom (MongoDB standard)
public interface PortfolioRepository
        extends MongoRepository<PortfolioData, String> {

}