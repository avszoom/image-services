package com.avszoom.timelineservice.models;

import com.avszoom.timelineservice.repositories.ImageEntityProjection;

import java.util.List;

public class ImageList {
    List<ImageEntityProjection> images;

    public ImageList() {
    }

    public ImageList(List<ImageEntityProjection> images) {
        this.images = images;
    }

    public List<ImageEntityProjection> getImages() {
        return images;
    }

    public void setImages(List<ImageEntityProjection> images) {
        this.images = images;
    }
}
