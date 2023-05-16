package com.example.consumingwedservices.consumingwebservices;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ws.numberconversion.*;

@SpringBootApplication
public class ConsumingwebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingwebservicesApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(convertClient convertclient) {
		return args -> {

			NumberToDollarsResponse Response = convertclient.convertToDollar(new BigDecimal(154.24));
			NumberToWordsResponse Response2 = convertclient.convertToWords(new BigInteger("15489"));
			String information = Response.getNumberToDollarsResult();
			String information2 = Response2.getNumberToWordsResult();
			System.err.println("number to dollars : " + information);
			System.err.println("number to words : " + information2);

		};
	}
}
