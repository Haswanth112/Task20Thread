 class MyThread extends Thread {
    MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " Value " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread " + Thread.currentThread().getName()+ " interrupted");
            }
            Thread.yield();
        }
    }
}
public class MultiThreadExample {
    public static void main(String args[]) {
        MyThread t1 = new MyThread("Haswanth");
        t1.start();
        MyThread t2 = new MyThread("Is a Good Boy");
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();

        System.out.println("Main thread exiting.");
    }
}


