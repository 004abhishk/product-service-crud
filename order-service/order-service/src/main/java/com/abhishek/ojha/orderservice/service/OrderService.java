package com.abhishek.ojha.orderservice.service;

import com.abhishek.ojha.orderservice.entity.Order;
import com.abhishek.ojha.orderservice.entity.Product;
import com.abhishek.ojha.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

import java.util.*;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Order createOrder(Order order) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        /*String url = "http://localhost:8080/restService/{urlParameter}?queryParameter= {queryParameter}";
        ////localhost:9192/product
        Map<String, String> uriVariables = new HashMap<>();

        uriVariables.put("urlParameter", "myURLParameter");
        uriVariables.put("queryParameter", "myQueryParameter");*/
        List<Map> products = restTemplate.exchange("http://localhost:9192/product", HttpMethod.GET, entity, List.class).getBody();
        Map<String, String> productMap = new LinkedHashMap<>();

        Product product = new Product();
        boolean isProductPresent = false;
        for(int i=0; i<products.size(); i++){
            Map<String, String> productMap1 = products.get(i);
            for(Map.Entry entry: productMap1.entrySet()){
                String key = entry.getKey().toString();
                Object value = entry.getValue();
                if(entry.getValue().equals(order.getProductName())){
                    isProductPresent = true;
                    product.setProductName(value.toString());

                }
                if(key.equalsIgnoreCase("price")){
                    product.setPrice(Long.valueOf(value.toString()));
                }
            }
            if(isProductPresent){
                break;
            }
        }
        order.setOrderAmount(order.getQuantity()*product.getPrice());
       // boolean isProduct = products.stream().anyMatch(product -> product.getProductName().equals(order.getProductName()));
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
