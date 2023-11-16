import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeapYearUsingStreams {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.addAll(Arrays.asList(1998,2000,2001,2003,2003,2004,2005,2006,2006,2007,2010,2008,2008));
        list.stream().filter(a->a%4==0 && a%100!=0 || (a%100==0 && a%400==0)).distinct().forEach(System.out::println);
    }
}
