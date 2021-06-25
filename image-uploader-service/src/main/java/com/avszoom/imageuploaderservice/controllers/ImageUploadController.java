package com.avszoom.imageuploaderservice.controllers;

import com.avszoom.imageuploaderservice.models.Image;
import com.avszoom.imageuploaderservice.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
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

    @GetMapping("/image/{id}")
    public Image getServiceName(@PathVariable("id") Integer id) {
        log.log(Level.INFO, "fetching Image for Id : " + id);
        return imageService.getImage(id);
    }
}
