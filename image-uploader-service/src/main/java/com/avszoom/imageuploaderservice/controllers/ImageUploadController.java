package com.avszoom.imageuploaderservice.controllers;


import com.avszoom.imageuploaderservice.models.ImageList;
import com.avszoom.imageuploaderservice.services.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageUploadController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ImageService imageService;

    @GetMapping("/servicename")
    public String getServiceName(){
        LOG.info("Get Service name.....");
        return "image-uploader-service";
    }

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        LOG.info("Push Upload.....");
        return imageService.uploadImage(file);
    }

    @GetMapping("/images/{username}")
    public ImageList fetchImage(@PathVariable("username") String user) {
        LOG.info("Get images for user....." + user);
        return imageService.getImages(user);
    }
}
