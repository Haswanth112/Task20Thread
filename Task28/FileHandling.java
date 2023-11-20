
import java.io.File;
import java.io.IOException;

public class FileHandling
{
    public static void main(String args[]) throws IOException {
        File folder=new File("D:\\TestFiles");
        System.out.println(folder.mkdir());
        File file=new File("D:\\TestFiles\\Sample.Txt");
        System.out.println(file.createNewFile());
       // file.delete();
       //folder.delete();

    }
}
