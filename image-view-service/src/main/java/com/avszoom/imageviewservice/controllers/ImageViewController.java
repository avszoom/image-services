package com.avszoom.imageviewservice.controllers;

import com.avszoom.imageviewservice.models.Image;
import com.avszoom.imageviewservice.models.ImageList;
import com.avszoom.imageviewservice.services.ImageViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ImageViewController {

    @Autowired
    ImageViewService imageViewService;

    @GetMapping("/")
    public String getIndex(Model model){
        model.addAttribute("header", "Image Upload");
        return "index";
    }

    @Value("${timeline-service.url}")
    String imageServiceUrl;

    @Value("${image-upload-service.url}")
    String imageUploadUrl;

    @GetMapping("/uploadImage")
    public String getUploadImgePage(Model model){
        model.addAttribute("url", imageUploadUrl + "uploadImage");
        return "image-upload.html";
    }

    @GetMapping("/timeline")
    public String getTimeLine(Model model){
        ImageList images  = imageViewService.getImages("system");
        model.addAttribute("images", images);
        model.addAttribute("url", imageServiceUrl + "image/");
        return "timeline.html";
    }


}
