import java.io.*;
import java.util.Scanner;

public class DisplayContent {
    public static void main(String[] args) {
        File file=new File("F:\\Testfiles123.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileReader reader=new FileReader(file);
            Scanner p=new Scanner(reader);
            while(p.hasNext()){
                System.out.println(p.next());
            }
            p.close();
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Message :");
        String st= sc.nextLine();
        sc.close();
        try {
            FileWriter wrtr=new FileWriter(file);
            wrtr.write(st);
            wrtr.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
