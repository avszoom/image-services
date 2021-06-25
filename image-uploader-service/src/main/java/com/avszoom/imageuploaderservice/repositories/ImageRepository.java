package com.avszoom.imageuploaderservice.repositories;

import com.avszoom.imageuploaderservice.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image,Integer> {
}
