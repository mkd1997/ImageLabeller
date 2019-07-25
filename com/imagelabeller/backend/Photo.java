package com.imagelabeller.backend;

public class Photo {
    String name;
    String caption;
    String path;

    Photo(String name, String path) {
        this.name = name;
        this.path = path;
        this.caption = "";
    }

    @Override
    public String toString() {
        String photoStr = "";
        photoStr += ("Name: " + this.name + "\n");
        photoStr += ("Caption: " + this.caption + "\n");
        photoStr += ("Path: " + this.path + "\n");
        return photoStr;
    }

    // public Photo(PhotoAlbum) {

    // }
}