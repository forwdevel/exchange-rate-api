// ExchangeResponse.java
package com.example.exchange.dto;

import lombok.Data;

@Data
public class ExchangeResponse {
    private String from;
    private String to;
    private double rate;
}
