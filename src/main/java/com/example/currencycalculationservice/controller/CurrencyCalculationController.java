package com.example.currencycalculationservice.controller;


//import com.example.currencycalculationservice.model.CalculatedAmount;
import com.example.currencycalculationservice.Dto.ExchangeRequest;
import com.example.currencycalculationservice.Dto.ExchangeResponse;
import com.example.currencycalculationservice.model.ExchangeValue;
//import com.example.currencycalculationservice.payloads.CustomApiResponse;
//import com.example.currencycalculationservice.payloads.CustomApiResponse;
import com.example.currencycalculationservice.service.CalculatedService;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CurrencyCalculationController {

    @Autowired
    private CalculatedService service;


//ResponseEntity<ExchangeResponse>.
// This allows us to return an HTTP response with a specific status code and headers.
    //The ResponseEntity.ok(response) method is used to create a response entity with the response object as the body.
// The ok() method sets the HTTP status code to 200 (OK) by default.
    @PostMapping(value = "/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<ExchangeResponse> calculateAmount(@Valid @RequestBody ExchangeRequest exchangeRequest,
                                                            @PathVariable String from,
                                                            @PathVariable String to,
                                                            @PathVariable int quantity) {
        exchangeRequest.setFrom(from);
        exchangeRequest.setTo(to);
        ExchangeResponse response = service.calculateAmount(exchangeRequest, quantity);
       return ResponseEntity.ok(response);
      // return new ResponseEntity(new CustomApiResponse("Response Status Success",true), HttpStatus.OK);
    }


    @GetMapping("/transactions")
    public ResponseEntity<List<ExchangeResponse>> getAllTransactions() {
        List<ExchangeResponse> transactions = service.getAllTransactions();
      return ResponseEntity.ok(transactions);
      //  return new ResponseEntity(new CustomApiResponse("All transactions Feteched Success",true), HttpStatus.OK);
    }

}
