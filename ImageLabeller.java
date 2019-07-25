import com.imagelabeller.backend.*;
import java.io.*;

public class ImageLabeller {
    public static void main(String[] args) {
        Directory dirObj = new Directory("./TestImages");
        dirObj.showFiles("size");
        dirObj.next(3);
        dirObj.previous(3);
        dirObj.next(5);
        dirObj.previous(0);

        System.out.println("");

        int[] albumPics = {1,3,5};
        PhotoAlbum pa = new PhotoAlbum(dirObj, albumPics);
        System.out.println(pa);
        System.out.println("");

        File newPic =  dirObj.getImageFiles().get(4);
        pa.addToAlbum(newPic);
        System.out.println(pa);
        System.out.println("");

        pa.delFromAlbum(3);
        System.out.println(pa);
        System.out.println("");
    }
}