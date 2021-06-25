package com.avszoom.imageuploaderservice.controllers;

import com.avszoom.imageuploaderservice.models.Image;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ImageUploadController {
    Logger log = Logger.getLogger(ImageUploadController.class.getName());
    @GetMapping("/servicename")
    public String getServiceName(){
        return "image-uploader-service";
    }

    @GetMapping("/image/{id}")
    public Image getServiceName(@PathVariable("id") String id) {
        log.log(Level.INFO, "getting hit by : " + id);
        return new Image(id);
    }
}
