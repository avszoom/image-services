package com.avszoom.imageuploaderservice.services;

import com.avszoom.imageuploaderservice.models.Image;
import com.avszoom.imageuploaderservice.models.ImageList;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    ImageList getImages(String user);
    String uploadImage(MultipartFile file);
}
