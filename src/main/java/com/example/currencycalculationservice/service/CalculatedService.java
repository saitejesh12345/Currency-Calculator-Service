package com.example.currencycalculationservice.service;


import com.example.currencycalculationservice.Dto.ExchangeRequest;
import com.example.currencycalculationservice.Dto.ExchangeResponse;
import com.example.currencycalculationservice.model.ExchangeValue;
import com.example.currencycalculationservice.repository.ExchangeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatedService {
    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeRepo exchangeRepo;




    public ExchangeResponse calculateAmount(ExchangeRequest exchangeRequest, int quantity) {
        ExchangeValue exchangeValue = new ExchangeValue();
       // This line creates a new instance of the ExchangeValue class.
        exchangeValue.setFrom(exchangeRequest.getFrom());
          //This line sets the from value from the exchangeRequest object to
        // the exchangeValue object. The getFrom method is assumed to be a getter
        // method in the ExchangeRequest class.
        exchangeValue.setTo(exchangeRequest.getTo());
        //This line sets the to value from the exchangeRequest object to the
        // exchangeValue object. The getTo method is assumed to be a getter method in the
        // ExchangeRequest class.
        exchangeValue.setConversionMultiple(exchangeRequest.getConversionMultiple());
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        exchangeValue.setQuantity(quantity);
        //This line sets the quantity value from the quantity variable to the exchangeValue object.
         // Calculate the total calculated amount
        BigDecimal calculatedAmount = exchangeRequest.getConversionMultiple().multiply(BigDecimal.valueOf(quantity));
        exchangeValue.setTotalCalculatedAmount(calculatedAmount.doubleValue());
    //This line calculates the total calculated amount by multiplying the conversionMultiple from the exchangeRequest
        // object with the quantity variable. The result is stored in a BigDecimal variable called calculatedAmount.

        // Persist the exchangeValue object using JPA repository.
        // It saves the exchangeValue object to a database
        exchangeRepo.save(exchangeValue);


        ExchangeResponse exchangeResponse = new ExchangeResponse();
        //This line creates a new instance of the ExchangeResponse class.
        exchangeResponse.setId(exchangeValue.getId());
        //This line sets the id value from the exchangeValue object to the exchangeResponse object.
        exchangeResponse.setFrom(exchangeValue.getFrom());
        //This line sets the from value from the exchangeValue object to the exchangeResponse object.
        exchangeResponse.setTo(exchangeValue.getTo());
        exchangeResponse.setConversionMultiple(exchangeValue.getConversionMultiple());
        exchangeResponse.setPort(exchangeValue.getPort());
        exchangeResponse.setQuantity(exchangeValue.getQuantity());
        exchangeResponse.setTotalCalculatedAmount(calculatedAmount.doubleValue());
        //This line sets the totalCalculatedAmount value from the calculatedAmount BigDecimal variable
        // to the exchangeResponse object.
        return exchangeResponse;
        //This line returns the exchangeResponse object as the result of the calculateAmount method.

        //In summary, this code takes an ExchangeRequest object and a quantity variable as input.
        // It creates an ExchangeValue object, sets its properties based on the input, calculates the total calculated amount,
        // and persists the ExchangeValue object using a JPA repository. Then, it creates an ExchangeResponse object,
        // sets its properties based on the ExchangeValue object, and returns it as the result of the method.
    }

    public List<ExchangeResponse> getAllTransactions() {
        List<ExchangeValue> exchangeValues = exchangeRepo.findAll();
        //This line retrieves all the ExchangeValue objects from the exchangeRepo repository using the findAll() method.
        // It assigns the list of retrieved objects to the exchangeValues variable.

        List<ExchangeResponse> transactions = new ArrayList<>();
        //This line creates a new ArrayList called transactions to store the converted ExchangeResponse objects
        for (ExchangeValue exchangeValue : exchangeValues) {
            //This line starts a loop that iterates over each ExchangeValue object in the exchangeValues list.
            ExchangeResponse transaction = new ExchangeResponse();
            //This line creates a new instance of the ExchangeResponse class for each ExchangeValue object.
            transaction.setId(exchangeValue.getId());
            //This line sets the id value from the ExchangeValue object to the transaction object.
            transaction.setFrom(exchangeValue.getFrom());
            //This line sets the to value from the ExchangeValue object to the transaction object.
            transaction.setTo(exchangeValue.getTo());
            transaction.setConversionMultiple(exchangeValue.getConversionMultiple());
            transaction.setPort(exchangeValue.getPort());
            transaction.setQuantity(exchangeValue.getQuantity());
            //This line sets the quantity value from the ExchangeValue object to the transaction object.
            transaction.setTotalCalculatedAmount(exchangeValue.getTotalCalculatedAmount());
            //This line sets the totalCalculatedAmount value from the ExchangeValue object to the transaction object.
            transactions.add(transaction);
            //This line adds the transaction object to the transactions list.
        }
//In summary, this code retrieves all ExchangeValue objects from the repository using the findAll() method.
// It then converts each ExchangeValue object into an ExchangeResponse object by setting the corresponding properties.
// These converted objects are added to a list called transactions.
// Finally, the transactions list is returned as the result of the getAllTransactions method.
        return transactions;
    }

}