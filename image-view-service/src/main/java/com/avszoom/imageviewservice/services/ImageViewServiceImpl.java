package com.avszoom.imageviewservice.services;

import com.avszoom.imageviewservice.models.FileEntity;
import com.avszoom.imageviewservice.models.Image;
import com.avszoom.imageviewservice.models.ImageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ImageViewServiceImpl implements ImageViewService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${timeline-service.url}")
    String imageServiceUrl;


    @Override
    public ImageList getImages(String user) {
        ImageList result = restTemplate.getForObject(imageServiceUrl + "images/system", ImageList.class);
        return result;
    }

}
