package com.codingworld.numberconversion;
import com.codingworld.numberconversion.NumberConversion;

import java.lang.reflect.Type;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NumberConsumer {

  @PostConstruct
  public void consumer() {
    String url = "http://localhost:8090/getNumbers";
    RestTemplate template = new RestTemplate();
    ResponseEntity<List<NumberConversion>> numbers = template.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
            new ParameterizedTypeReference<List<NumberConversion>>() {
              @Override
              public Type getType() {
                return super.getType();
              }
            });
    List<NumberConversion> list = numbers.getBody();
    System.out.println("Size:" + list.size());
    if (list.size() > 0) {
      for (NumberConversion nb : list) {
        System.out.println(nb.getNumber() + " convertir en euro : " + convertToEuro(nb.getNumber()) + " euro");
      }
    }
  }

  private String convertToEuro(String amount) {
    double conversionRate = 0.85;
    double amountInEuro = Double.parseDouble(amount) * conversionRate;
    return String.valueOf(amountInEuro);
  }
}
