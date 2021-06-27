package com.avszoom.imageuploaderservice.repositories;

import com.avszoom.imageuploaderservice.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image,Integer> {
    List<Image> findByUser(String user);
}
