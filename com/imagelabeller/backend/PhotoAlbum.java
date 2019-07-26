package com.imagelabeller.backend;

import com.imagelabeller.backend.*;
import java.util.*;
import java.io.*;

public class PhotoAlbum {
    String albumName;
    String albumPath;
    ArrayList<Photo> albumPhotos;    

    public PhotoAlbum(String albumName, Directory dirObj, int[] indexes) {
        this.albumName = new String(albumName);
        this.albumPath = dirObj.dirPath;

        this.albumPhotos = new ArrayList<Photo>();        
        for(int index : indexes) {
            String name = dirObj.imageFiles.get(index).getName();
            String path = dirObj.imageFiles.get(index).getPath();

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

    public void addCaptionToPhoto(int index, String caption) {
        Photo photoObj = this.albumPhotos.get(index);
        photoObj.caption = caption;
    }

    public void writeCaptionsToFile(String filepath) {
        String photoAlbumStr = "";
        photoAlbumStr += ("Album Name: " + this.albumName + "\n");
        photoAlbumStr += ("Path: " + this.albumPath + "\n");
        for(Photo pic : albumPhotos) {
            if(pic.caption.equals("") == false) {
                photoAlbumStr += (pic.toString() + "\n");
            }            
        }

        try {
            FileWriter fw = new FileWriter(filepath);
            fw.write(photoAlbumStr);
            fw.close();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        String photoAlbumStr = "";
        photoAlbumStr += ("Album Name: " + this.albumName + "\n");
        photoAlbumStr += ("Path: " + this.albumPath + "\n");
        for(Photo pic : albumPhotos) {
            photoAlbumStr += (pic.toString() + "\n");
        }
        return photoAlbumStr;
    }
}