package com.avszoom.timelineservice.repositories;

import com.avszoom.timelineservice.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimelineRepository extends JpaRepository<Image,Integer> {
    List<ImageEntityProjection> findByUser(String user);
    ByteImageProjection findByUuid(String uuid);
}
