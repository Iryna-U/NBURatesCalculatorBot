package com.github.iv.nbu_rates_calculator_bot;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "nbu-client", url = "https://bank.gov.ua/NBUStatService/v1/statdirectory")
public interface NBUClient {

    @GetMapping("/exchange?json")
    List<NBUResponseDto> getData();
}
