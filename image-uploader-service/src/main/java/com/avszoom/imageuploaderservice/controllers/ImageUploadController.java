package com.avszoom.imageuploaderservice.controllers;

import com.avszoom.imageuploaderservice.models.Image;
import com.avszoom.imageuploaderservice.models.ImageList;
import com.avszoom.imageuploaderservice.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class ImageUploadController {
    Logger log = Logger.getLogger(ImageUploadController.class.getName());

    @Autowired
    ImageService imageService;

    @GetMapping("/servicename")
    public String getServiceName(){
        return "image-uploader-service";
    }

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        return imageService.uploadImage(file);
    }

    @GetMapping("/images/{username}")
    public ImageList uploadImage(@PathVariable("username") String user) {
        return imageService.getImages(user);
    }
}
