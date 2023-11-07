import static java.lang.Thread.sleep;
class Alpha implements Runnable{
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("This is thread Alpha"+i);
            try{
                if(i%2!=0){
                    sleep(500);
                }
            }
            catch(InterruptedException e){
                System.out.println("Interrupted"+e.getMessage());
            }
        }
    }
}
class Beta implements Runnable{
    public void run() {
        for(int i=10;i>0;i--){
            System.out.println("This is thread Beta:"+i);
        try {
            if(i%2==0){
                sleep(500);
            }
        }
        catch (InterruptedException e){
            System.out.println("Interrupted"+e.getMessage());
        }
        }
    }
}
public class ThreadwithRunnable {
    public static void main(String[] args) {
        Alpha a=new Alpha();
        Thread t1=new Thread(a);
        Beta b=new Beta();
        Thread t2=new Thread(b);
        t1.start();
        t2.start();
    }
}