package com.tron.configserver;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConfigController {

    @GetMapping("/refresh")
    public Object refresh() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, header);
        Object forObject = restTemplate.postForObject("http://localhost:8000/actuator/bus-refresh", httpEntity, Object.class);
        return "success";
    }
}
