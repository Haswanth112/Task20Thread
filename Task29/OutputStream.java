import java.io.*;
import java.util.Arrays;

public class OutputStreamExample{
    public static void main(String args[]) {
        File file=new File("E:\\TestFile.Txt");
        try {
            file.createNewFile();
            FileOutputStream out=new FileOutputStream(file);
            out.write(24);
            out.write(20);
            out.write(30);
            out.close();
            System.out.println("Data added to file");
        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
       
     // FileInputStream obj=new FileInputStream(file);

        //System.out.println(Arrays.toString(obj.readAllBytes()));





    }
}
