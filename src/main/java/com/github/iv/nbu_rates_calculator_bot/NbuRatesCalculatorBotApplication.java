package com.github.iv.nbu_rates_calculator_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NbuRatesCalculatorBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(NbuRatesCalculatorBotApplication.class, args);
	}

}

