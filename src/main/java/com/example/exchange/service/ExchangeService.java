// ExchangeService.java
package com.example.exchange.service;

import com.example.exchange.dto.ExchangeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ExchangeService {
    private final RestTemplate restTemplate;

    @Value("${api.exchangerate.access-key}")
    private String accessKey;

    public ExchangeResponse getExchageRate(String from, String to) {
        String url = "https://api.exchangerate.host/convert?access_key=" + accessKey + "&from=" + from + "&to=" + to + "&amount=1";;
        System.out.println("요청 URL: " + url);

        ExternalApiResponse response = restTemplate.getForObject(url, ExternalApiResponse.class);

        if (response != null && response.isSuccess()) {
            return new ExchangeResponse(from, to, response.getResult());
        } else {
            throw new RuntimeException("환율 정보를 가져올 수 없습니다.");
        }
    }

    private static class ExternalApiResponse {
        private boolean success;
        private double result;

        public boolean isSuccess() {
            return success;
        }

        public double getResult() {
            return result;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public void setResult(double result) {
            this.result = result;
        }
    }
}
