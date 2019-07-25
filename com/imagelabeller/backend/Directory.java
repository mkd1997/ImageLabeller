package com.imagelabeller.backend;

import java.io.*;
import java.util.*;

public class Directory {
    ArrayList<File> imageFiles;
    int imgFileCount;
    String dirPath;

    public Directory(String dirPath) {
        File dirFolder = new File(dirPath);
        this.dirPath = dirPath;
        
        FilenameFilter imgFileFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(name.endsWith(".jpg")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        this.imageFiles = new ArrayList<File>(Arrays.asList(dirFolder.listFiles(imgFileFilter)));
        this.imgFileCount = this.imageFiles.size();
    }

    public ArrayList<File> getImageFiles() {
        return this.imageFiles;
    }

    public void showFiles(String sortBy) {
        int i = 0;
        switch (sortBy) {
            case "name":
                Collections.sort(this.imageFiles, new FilenameComparator());
                break;

            case "size":
                Collections.sort(this.imageFiles, new SizeComparator());
                break;
        
            default:
                Collections.sort(this.imageFiles, new FilenameComparator());
                break;
        }
        for(File imgFile : this.imageFiles) {
            System.out.println(i + ". " + imgFile.getName());
            i++;
        }
    }

    public int next(int currentImage) {
        int nextImage = (currentImage + 1) % this.imgFileCount;
        System.out.println(this.imageFiles.get(nextImage).getName());
        return nextImage;
    }

    public int previous(int currentImage) {
        int prevImage;
        if(currentImage <= 0) {
            prevImage = currentImage + this.imgFileCount -1;
            System.out.println(this.imageFiles.get(prevImage).getName());
            return prevImage;
        } else {
            prevImage = (currentImage - 1) % this.imgFileCount;
            System.out.println(this.imageFiles.get(prevImage).getName());
            return prevImage;
        }        
    }

    // public static void main(String[] args) {
    //     Directory obj = new Directory(".");
    //     obj.showFiles();        
    // }
}