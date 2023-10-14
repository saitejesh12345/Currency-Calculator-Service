package com.example.currencycalculationservice.controller;


//import com.example.currencycalculationservice.model.CalculatedAmount;
import com.example.currencycalculationservice.Dto.ExchangeRequest;
import com.example.currencycalculationservice.Dto.ExchangeResponse;
import com.example.currencycalculationservice.model.ExchangeValue;
import com.example.currencycalculationservice.service.CalculatedService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CurrencyCalculationController {

    @Autowired
    private CalculatedService service;

//    @PostMapping(value = "/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
//    @ApiOperation("Calculate the total calculated amount based on the conversion multiple and quantity")
//    @ResponseBody
//    public ResponseEntity<ExchangeValue> calculateAmount(
//            @RequestBody ExchangeValue exchangeValue,
//            @ApiParam(value = "The quantity is  example 10") @PathVariable int quantity) {
//        exchangeValue.setQuantity(quantity);
//        ExchangeValue result = service.calculateAmount();
//        exchangeValue.setTotalCalculatedAmount(result.getTotalCalculatedAmount());
//        return ResponseEntity.ok(exchangeValue);
//    }
//@PostMapping(value = "/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
//public ExchangeValue calculateAmount(@RequestBody ExchangeValue exchangeValue,
//                                     @PathVariable String from,
//                                     @PathVariable String to, @ApiParam(value = "The quantity is example 10") @PathVariable int quantity) {
//    exchangeValue.setFrom(from);
//    exchangeValue.setTo(to);
//    exchangeValue.setQuantity(quantity);
//    return service.calculateAmount(exchangeValue, quantity);
//}

    @PostMapping(value = "/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public ExchangeResponse calculateAmount(@RequestBody ExchangeRequest exchangeRequest,
                                            @PathVariable String from,
                                            @PathVariable String to, @ApiParam(value = "The quantity is example 10")
                                                @PathVariable int quantity) {
        exchangeRequest.setFrom(from);
       exchangeRequest.setTo(to);
        return service.calculateAmount(exchangeRequest,quantity);
    }
}
