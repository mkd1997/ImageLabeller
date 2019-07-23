package com.imagelabeller.backend;

import com.imagelabeller.backend.*;
import java.util.*;
import java.io.*;

public class PhotoAlbum {
    String albumPath;
    ArrayList<Photo> albumPhotos;    

    public PhotoAlbum(Directory dirObj, int[] indexes) {
        this.albumPath = dirObj.dirPath;

        this.albumPhotos = new ArrayList<Photo>();        
        for(int index : indexes) {
            String name = dirObj.imageFiles[index].getName();
            String path = dirObj.imageFiles[index].getPath();

            Photo photoObj = new Photo(name, path);
            this.albumPhotos.add(photoObj);
        }
    }

    public void addToAlbum(File photo) {
        String name = photo.getName();
        String path = photo.getPath();

        Photo photoObj = new Photo(name, path);
        this.albumPhotos.add(photoObj);
    }

    public void delFromAlbum(int index) {
        this.albumPhotos.remove(index);
    }

    public String toString() {
        String photoAlbumStr = "";
        photoAlbumStr += ("Path: " + this.albumPath + "\n");
        for(Photo pic : albumPhotos) {
            photoAlbumStr += (pic.toString() + "\n");
        }
        return photoAlbumStr;
    }
}