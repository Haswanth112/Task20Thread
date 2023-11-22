import java.io.*;
import java.util.Scanner;
public class ReaderWriteFile{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a message :");
        String st=sc.nextLine();
        File file=new File("F:\\Test777");
        try {
            FileWriter writer=new FileWriter(file);
            writer.write(st);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try{
            FileReader reader=new FileReader(file);
            BufferedReader bfrd=new BufferedReader(reader);
            String line;
            while((line= bfrd.readLine())!=null){
                System.out.println(line+"\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
