
import java.io.File;
import java.io.IOException;

public class FileHandling {
    public static void main(String args[]) throws IOException {
        File folder = new File("D:\\TestFiles");
        if (folder.exists()) {
            System.out.println("Folder Already exist");
        } else {
            System.out.println(folder.mkdir());
            System.out.println("Folder Created");
        }
        File file = new File("D:\\TestFiles\\Sample.Txt");
        if (file.exists()) {
            System.out.println("File Already Exists");
        } else {
            System.out.println(file.createNewFile());
            System.out.println("File Created");
        }

        file.delete();
        folder.delete();
    }
}
