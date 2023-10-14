//package com.example.currencycalculationservice.model;
//
//import lombok.Data;
//
//import java.math.BigDecimal;
//
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//
//@Data
//@Entity
//public class CalculatedAmount {
//
//        @Id
//        private long id;
//
//        @Column(name = "currency_from")
//        private String from;
//
//        @Column(name = "to_currency")
//        private String  to;
//        private BigDecimal conversionMultiple;
//
//        private int port;
//
//        private int quantity;
//
//        private double totalCalculatedAmount;
//
//        public ExchangeValue(long id, String from, String to, BigDecimal conversionMultiple, int port) {
//            this.id = id;
//            this.from = from;
//            this.to = to;
//            this.conversionMultiple = conversionMultiple;
//            this.port = port;
//        }
//
//        public ExchangeValue(long id, String from, String to, BigDecimal conversionMultiple) {
//            this.id = id;
//            this.from = from;
//            this.to = to;
//            this.conversionMultiple = conversionMultiple;
//        }
//
//        public ExchangeValue() {
//        }
//
//        @Override
//        public String toString() {
//            return "ExchangeValue{" +
//                    "id=" + id +
//                    ", from='" + from + '\'' +
//                    ", to='" + to + '\'' +
//                    ", conversionMultiple=" + conversionMultiple +
//                    ", port=" + port +
//                    '}';
//        }
//    }
//
//
