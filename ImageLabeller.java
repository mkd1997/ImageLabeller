import com.imagelabeller.backend.*;
import java.io.*;

public class ImageLabeller {
    public static void main(String[] args) {
        // User enters the path of the drectory where 
        // album has to be started.
        Directory dirObj = new Directory("./TestImages");

        // User is shown the image files in the directory.
        // He is given the controls to sort the list by name or size
        dirObj.showFiles("size");

        // User is given controls to browse through the directory
        dirObj.next(3);
        dirObj.previous(3);
        dirObj.next(5);
        dirObj.previous(0);
        System.out.println("");

        // User selects the photos to be included 
        // in the album
        int[] albumPics = {1,3,5};
        PhotoAlbum pa = new PhotoAlbum("My Memories", dirObj, albumPics);
        System.out.println(pa);
        System.out.println("");

        // User can add a photo to the album 
        File newPic =  dirObj.getImageFiles().get(4);
        pa.addToAlbum(newPic);
        System.out.println(pa);
        System.out.println("");

        // User can delete a photo from the album
        pa.delFromAlbum(3);
        System.out.println(pa);
        System.out.println("");

        // User selects a photo and enters the caption for the same
        pa.addCaptionToPhoto(1, "This place, that day");
        pa.addCaptionToPhoto(0, "Unforgettable!");
        pa.writeCaptionsToFile("./TestImages/MyMemories.txt");

        pa.addCaptionToPhoto(1, "New Caption");
        pa.writeCaptionsToFile("./TestImages/MyMemories.txt");
    }
}