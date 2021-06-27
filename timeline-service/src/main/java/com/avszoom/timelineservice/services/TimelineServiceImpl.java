package com.avszoom.timelineservice.services;

import com.avszoom.timelineservice.models.ImageList;
import com.avszoom.timelineservice.repositories.TimelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TimelineServiceImpl implements TimelineService {

    @Autowired
    TimelineRepository timelineRepository;

    @Override
    public ImageList getImages(String user) {
        ImageList imageList = new ImageList(timelineRepository.findByUser(user));
        return imageList;
    }

    @Override
    public byte[] getImage(String uuid) {
      return timelineRepository.findByUuid(uuid).getData();
    }


}
