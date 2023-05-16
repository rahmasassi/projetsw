package com.example.consumingwedservices.consumingwebservices;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.ws.numberconversion.*;

public class convertClient extends WebServiceGatewaySupport {

    public NumberToDollarsResponse convertToDollar(BigDecimal number) {

        NumberToDollars request = new NumberToDollars();
        request.setDNum(number);
        NumberToDollarsResponse information = (NumberToDollarsResponse) getWebServiceTemplate()
                .marshalSendAndReceive("https://www.dataaccess.com/webservicesserver/numberconversion.wso", request,
                        new SoapActionCallback(
                                ""));
        return information;
    }

    public NumberToWordsResponse convertToWords(BigInteger number) {

        NumberToWords request = new NumberToWords();
        request.setUbiNum(number);
        NumberToWordsResponse information = (NumberToWordsResponse) getWebServiceTemplate()
                .marshalSendAndReceive("https://www.dataaccess.com/webservicesserver/numberconversion.wso", request,
                        new SoapActionCallback(
                                ""));
        return information;
    }

}