package com.avszoom.imageviewservice.models;

public class Image {

    String uuid;

    String name;

    String user;


    public Image() {
    }

    public Image(String uuid, String name, String user) {
        this.uuid = uuid;
        this.name = name;
        this.user = user;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
