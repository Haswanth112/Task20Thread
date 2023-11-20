import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LeapYearUsingStreams {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        Scanner s =new Scanner(System.in);
        System.out.println("Enter the Years Separated by comma :");
        String[] b=s.nextLine().split(",");
        Arrays.stream(b).forEach(n->{list.add(Integer.parseInt(n));});
        list.stream().
                filter(a->a%4==0 && a%100!=0 || (a%100==0 && a%400==0)).
                distinct().
                forEach(System.out::println);
    }
}
