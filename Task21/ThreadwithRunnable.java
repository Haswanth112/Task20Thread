class Alpha implements Runnable
{
public void run()
{
try{

for(int i=0;i<10;i++)
{
System.out.println("This is thread Alpha: "+i);
Thread.sleep(500);
}
}
catch(InterruptedException e){
System.out.println("Thread Alpha is interrupted");
}
}
}
class Beta implements Runnable{
public void run()
{
try{

for(int i=0;i<10;i++)
{
System.out.println("This is thread Beta: "+i);
Thread.sleep(500);
}
}
catch(InterruptedException e){
System.out.println("Thread Beta is interrupted");
}
}
}
public class ThreadwithRunnable
{
public static void main(String args[])
{
Alpha a=new Alpha();
Beta b=new Beta();
Thread t1=new Thread(a);
Thread t2=new Thread(b);
t1.start();
t2.start();
}
}

