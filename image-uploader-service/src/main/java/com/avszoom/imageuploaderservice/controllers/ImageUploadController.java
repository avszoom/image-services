package com.avszoom.imageuploaderservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageUploadController {

    @GetMapping("/servicename")
    public String getServiceName(){
        return "image-uploader-service";
    }
}
