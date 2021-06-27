package com.avszoom.imageuploaderservice.services;

import com.avszoom.imageuploaderservice.models.Image;
import com.avszoom.imageuploaderservice.models.ImageList;
import com.avszoom.imageuploaderservice.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public ImageList getImages(String user) {
        ImageList result = new ImageList(imageRepository.findByUser(user));
        return result;
    }

    @Override
    public String uploadImage(MultipartFile file) {
        try {
            Image obj = imageRepository.save(new Image(file.getName(), "system", file.getBytes()));
            return obj.getUuid();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
