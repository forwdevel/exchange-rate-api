package com.example.exchange.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExchangeResponse {
    private String from;
    private String to;
    private double rate;
}
