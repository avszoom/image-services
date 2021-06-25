package com.avszoom.imageuploaderservice.services;

import com.avszoom.imageuploaderservice.models.Image;
import com.avszoom.imageuploaderservice.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public Image getImage(Integer id) {
        Optional<Image> byId = imageRepository.findById(id);
        return byId.orElse(new Image());
    }
}
