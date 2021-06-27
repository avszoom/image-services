package com.avszoom.imageviewservice.services;

import com.avszoom.imageviewservice.models.Image;
import com.avszoom.imageviewservice.models.ImageList;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageViewService {
    ImageList getImages(String user);
}
