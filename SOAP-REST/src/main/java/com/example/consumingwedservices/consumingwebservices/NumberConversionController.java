package com.example.consumingwedservices.consumingwebservices;

import com.example.ws.numberconversion.NumberToDollars;
import com.example.ws.numberconversion.NumberToDollarsResponse;
import com.example.ws.numberconversion.NumberToWords;
import com.example.ws.numberconversion.NumberToWordsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
public class NumberConversionController {
    @Autowired
    private convertClient numberConversionSoapClient;

    @GetMapping("/numberToWords/{number}")
    public String numberToWords(@PathVariable("number") BigInteger number) {
        NumberToWords request = new NumberToWords();
        request.setUbiNum(number);
        NumberToWordsResponse response = numberConversionSoapClient.convertToWords(request.getUbiNum());
        return response.getNumberToWordsResult();
    }

    @GetMapping("/numberToDollars/{number}")
    public String numberToDollars(@PathVariable("number") BigDecimal number) {
        NumberToDollars request = new NumberToDollars();
        request.setDNum(number);
        NumberToDollarsResponse response = numberConversionSoapClient.convertToDollar(request.getDNum());
        return response.getNumberToDollarsResult();
    }


    @GetMapping(value = "/getNumbers")
    public List<NumberConversion> getNumberList() {
        List<NumberConversion> numbers=new ArrayList<>();
        NumberConversion nb1=new NumberConversion(1,"56");
        NumberConversion nb2=new NumberConversion(2,"78");
        NumberConversion nb3=new NumberConversion(3,"89");
        NumberConversion nb4=new NumberConversion(4,"123");
        NumberConversion nb5=new NumberConversion(5,"11");
        numbers.add(nb1);
        numbers.add(nb2);
        numbers.add(nb3);
        numbers.add(nb4);
        numbers.add(nb5);
        return numbers;
    }
}
