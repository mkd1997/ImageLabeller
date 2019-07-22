import com.imagelabeller.backend.*;

public class ImageLabeller {
    public static void main(String[] args) {
        Directory obj = new Directory("./TestImages");
        obj.showFiles();
        obj.next(3);
        obj.previous(3);
        obj.next(5);
        obj.previous(0);
    }
}