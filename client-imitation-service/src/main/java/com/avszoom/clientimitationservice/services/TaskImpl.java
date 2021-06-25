package com.avszoom.clientimitationservice.services;

import com.avszoom.clientimitationservice.models.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class TaskImpl implements Task {

    @Autowired
    RestTemplate restTemplate;

    public TaskImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${image-uploader-service.url}")
    String imageServiceUrl;

    @Override
    public String executeTask(String threadId) {
        Random r = new Random();
        Image img = restTemplate.getForObject(imageServiceUrl + r.nextLong(), Image.class);
        return "fetched Image: " + img.getName();
    }
}
