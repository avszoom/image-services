package com.avszoom.imageviewservice.models;

import org.springframework.web.multipart.MultipartFile;

public class FileEntity {
    MultipartFile file;

    public FileEntity() {
    }

    public FileEntity(MultipartFile file) {
        this.file = file;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
