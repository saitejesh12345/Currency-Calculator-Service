package com.example.currencycalculationservice.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExchangeResponse {

    private long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private int port;
    private int quantity;
    private double totalCalculatedAmount;


}
