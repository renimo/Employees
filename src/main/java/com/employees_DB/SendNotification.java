package com.employees_DB;

import org.springframework.web.client.RestTemplate;

import java.util.List;

public class SendNotification {
    public static void sendNotification(){ //List<String> newEmployees){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject("http://localhost:7000/notification/insertEmployee", String.class);
    }
//   public <T> T getForObject(String url, Class<T> responseType, Object... uriVariables) throws RestClientException {
//    public static void sendNotification(Employee employee) {
//    }
}
