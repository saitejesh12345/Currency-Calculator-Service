package com.example.currencycalculationservice.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "exchange_values")
public class ExchangeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "currency_from")
    private String from;

    @Column(name = "to_currency")
    private String to;

    private BigDecimal conversionMultiple;

    private int port;

    private int quantity;

    private double totalCalculatedAmount;

    public ExchangeValue() {
    }

    public ExchangeValue(String from, String to, BigDecimal conversionMultiple, int port, int quantity, double totalCalculatedAmount) {
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.port = port;
        this.quantity = quantity;
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    @Override
    public String toString() {
        return "ExchangeValue{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", conversionMultiple=" + conversionMultiple +
                ", port=" + port +
                ", quantity=" + quantity +
                ", totalCalculatedAmount=" + totalCalculatedAmount +
                '}';
    }
}
