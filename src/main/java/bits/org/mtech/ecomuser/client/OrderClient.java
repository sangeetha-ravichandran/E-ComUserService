package bits.org.mtech.ecomuser.client;

import bits.org.mtech.ecomuser.Model.Order;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class OrderClient {
  public List<Order> getOrdersByUser(Long userId) throws RestClientException, IOException {

    String baseUrl = "http://localhost:8081/orders/" + userId;
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<List> response = null;
    try {
      response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), List.class);
      /*List<String> body = new ArrayList<>();
      body.add("{" +
              "    orderId: 1," +
              "    orderDate: '12-12-2023'," +
              "    orderStatus: 'delivered'," +
              "}");
      body.add("{" +
              "    orderId: 2," +
              "    orderDate: '12-1-2023'," +
              "    orderStatus: 'pending'," +
              "}");
      response = new ResponseEntity<>(body, HttpStatus.OK);*/
    } catch (Exception ex) {
      System.out.println(ex);
    }
		System.out.println(response.getBody());
    return response.getBody();
  }

  private static HttpEntity<?> getHeaders() throws IOException {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
    return new HttpEntity<>(headers);
  }
}
