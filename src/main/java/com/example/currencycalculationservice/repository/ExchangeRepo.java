package com.example.currencycalculationservice.repository;

import com.example.currencycalculationservice.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExchangeRepo extends JpaRepository<ExchangeValue,Long> {
}
