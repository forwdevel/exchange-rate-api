// ExchangeController.java
package com.example.exchange.controller;

import com.example.exchange.service.ExchangeService;
import com.example.exchange.dto.ExchangeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExchangeController {
    private final ExchangeService exchageService;

    @GetMapping("/api/exchange")
    public ExchangeResponse getExchageRate(@RequestParam String from, @RequestParam String to) {
        return exchageService.getExchageRate(from, to);
    }
}
