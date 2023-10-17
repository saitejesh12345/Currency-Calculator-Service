package com.example.currencycalculationservice.service;


import com.example.currencycalculationservice.Dto.ExchangeRequest;
import com.example.currencycalculationservice.Dto.ExchangeResponse;
import com.example.currencycalculationservice.model.ExchangeValue;
import com.example.currencycalculationservice.repository.ExchangeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatedService {
    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeRepo exchangeRepo;


    //    public ExchangeValue calculateAmount(){
//
//        ExchangeValue result = new ExchangeValue();
//
//        BigDecimal conversionMultiple = result.getConversionMultiple();
//        int quantity = result.getQuantity();
//        BigDecimal totalAmount = conversionMultiple.multiply(BigDecimal.valueOf(quantity));
//        result.setTotalCalculatedAmount(totalAmount.doubleValue());
//        return result;
//
//    }
//public ExchangeValue calculateAmount(ExchangeValue exchangeValue, int quantity) {
//    double totalCalculatedAmount = exchangeValue.getConversionMultiple().doubleValue() * quantity;
//
//    exchangeValue.setTotalCalculatedAmount(totalCalculatedAmount);
//
//    exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
//    return exchangeValue;
//}

//    public ExchangeResponse calculateAmount(ExchangeRequest exchangeRequest, int quantity) {
//        ExchangeResponse exchangeResponse = new ExchangeResponse();
//
//        double totalCalculatedAmount = exchangeRequest.getConversionMultiple() * quantity;
//
//        exchangeResponse.setId(exchangeRequest.getId());
//        exchangeResponse.setFrom(exchangeRequest.getFrom());
//        exchangeResponse.setTo(exchangeRequest.getTo());
//        exchangeResponse.setConversionMultiple(exchangeRequest.getConversionMultiple());
//        exchangeResponse.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
//        exchangeResponse.setQuantity(quantity);
//        exchangeResponse.setTotalCalculatedAmount(totalCalculatedAmount);
//
//        return exchangeResponse;
//    }

//    public ExchangeResponse calculateAmount(ExchangeRequest exchangeRequest, int quantity) {
//        ExchangeValue exchangeValue = new ExchangeValue();
//        exchangeValue.setFrom(exchangeRequest.getFrom());
//        exchangeValue.setTo(exchangeRequest.getTo());
//        exchangeValue.setConversionMultiple(exchangeRequest.getConversionMultiple());
//        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
//        exchangeValue.setQuantity(quantity);
//
//        ExchangeValue savedExchangeValue = exchangeRepo.save(exchangeValue);
//        BigDecimal calculatedAmount = savedExchangeValue.getConversionMultiple().multiply(BigDecimal.valueOf(quantity));
//
//        // Save the exchangeValue object to the database using the repository
//
//
//        ExchangeResponse exchangeResponse = new ExchangeResponse();
//        exchangeResponse.setTotalCalculatedAmount(calculatedAmount.doubleValue());
//        BeanUtils.copyProperties(savedExchangeValue, exchangeResponse);
//
//        //In this updated code, the BeanUtils.copyProperties() method is used to copy
//        // the properties from the savedExchangeValue object to the exchangeResponse object.
//        // This eliminates the need to manually set each property individually.
//
//
//        return exchangeResponse;
//    }

//    public ExchangeResponse calculateAmount(ExchangeRequest exchangeRequest, int quantity) {
//        ExchangeResponse exchangeResponse = new ExchangeResponse();
//        exchangeResponse.setId(exchangeRequest.getId());
//        exchangeResponse.setFrom(exchangeRequest.getFrom());
//        exchangeResponse.setTo(exchangeRequest.getTo());
//        exchangeResponse.setConversionMultiple(exchangeRequest.getConversionMultiple());
//        exchangeResponse.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
//        exchangeResponse.setQuantity(quantity);
//
//        BigDecimal calculatedAmount = exchangeRequest.getConversionMultiple().multiply(BigDecimal.valueOf(quantity));
//        exchangeResponse.setTotalCalculatedAmount(calculatedAmount.doubleValue());
//
//        return exchangeResponse;
//    }

    public ExchangeResponse calculateAmount(ExchangeRequest exchangeRequest, int quantity) {
        ExchangeValue exchangeValue = new ExchangeValue();
        exchangeValue.setFrom(exchangeRequest.getFrom());
        exchangeValue.setTo(exchangeRequest.getTo());
        exchangeValue.setConversionMultiple(exchangeRequest.getConversionMultiple());
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        exchangeValue.setQuantity(quantity);
    // Calculate the total calculated amount
        BigDecimal calculatedAmount = exchangeRequest.getConversionMultiple().multiply(BigDecimal.valueOf(quantity));
        exchangeValue.setTotalCalculatedAmount(calculatedAmount.doubleValue());

        // Persist the exchangeValue object using JPA repository
        exchangeRepo.save(exchangeValue);


        ExchangeResponse exchangeResponse = new ExchangeResponse();
        exchangeResponse.setId(exchangeValue.getId());
        exchangeResponse.setFrom(exchangeValue.getFrom());
        exchangeResponse.setTo(exchangeValue.getTo());
        exchangeResponse.setConversionMultiple(exchangeValue.getConversionMultiple());
        exchangeResponse.setPort(exchangeValue.getPort());
        exchangeResponse.setQuantity(exchangeValue.getQuantity());
        exchangeResponse.setTotalCalculatedAmount(calculatedAmount.doubleValue());

        return exchangeResponse;
    }

    public List<ExchangeResponse> getAllTransactions() {
        List<ExchangeValue> exchangeValues = exchangeRepo.findAll();

        List<ExchangeResponse> transactions = new ArrayList<>();
        for (ExchangeValue exchangeValue : exchangeValues) {
            ExchangeResponse transaction = new ExchangeResponse();
            transaction.setId(exchangeValue.getId());
            transaction.setFrom(exchangeValue.getFrom());
            transaction.setTo(exchangeValue.getTo());
            transaction.setConversionMultiple(exchangeValue.getConversionMultiple());
            transaction.setPort(exchangeValue.getPort());
            transaction.setQuantity(exchangeValue.getQuantity());
            transaction.setTotalCalculatedAmount(exchangeValue.getTotalCalculatedAmount());
            transactions.add(transaction);
        }

        return transactions;
    }

}