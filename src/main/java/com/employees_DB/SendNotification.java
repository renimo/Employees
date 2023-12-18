package com.employees_DB;

import org.springframework.web.client.RestTemplate;

public class SendNotification {
    public static void sendNotification(){

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject("http://localhost:7000/notification/insertEmployee", String.class);
    }

//    public static void sendNotification(Employee employee) {
//    }
}
