package com.example.currencycalculationservice.Dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExchangeRequest {

    @JsonIgnore
    private int id;

    @JsonIgnore
    private String from;
    @JsonIgnore
    private String to;

    @NotBlank
    private BigDecimal conversionMultiple;


}
