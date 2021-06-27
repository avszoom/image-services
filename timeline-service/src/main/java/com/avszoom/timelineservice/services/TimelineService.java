package com.avszoom.timelineservice.services;

import com.avszoom.timelineservice.models.ImageList;

public interface TimelineService {
    ImageList getImages(String user);
    byte[] getImage(String uuid);
}
