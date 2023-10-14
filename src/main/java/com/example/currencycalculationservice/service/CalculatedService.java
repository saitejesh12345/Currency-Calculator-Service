package com.example.currencycalculationservice.service;


import com.example.currencycalculationservice.Dto.ExchangeRequest;
import com.example.currencycalculationservice.Dto.ExchangeResponse;
import com.example.currencycalculationservice.model.ExchangeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatedService {
    @Autowired
    private Environment environment;

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

    public ExchangeResponse calculateAmount(ExchangeRequest exchangeRequest, int quantity) {
        ExchangeResponse exchangeResponse = new ExchangeResponse();

        double totalCalculatedAmount = exchangeRequest.getConversionMultiple() * quantity;

        exchangeResponse.setId(exchangeRequest.getId());
        exchangeResponse.setFrom(exchangeRequest.getFrom());
        exchangeResponse.setTo(exchangeRequest.getTo());
        exchangeResponse.setConversionMultiple(exchangeRequest.getConversionMultiple());
        exchangeResponse.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        exchangeResponse.setQuantity(quantity);
        exchangeResponse.setTotalCalculatedAmount(totalCalculatedAmount);

        return exchangeResponse;
    }
}
