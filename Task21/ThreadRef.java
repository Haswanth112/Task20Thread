public class ThreadRef {
    public static void main(String[] args) {
        Thread firstThread = new Thread(new MyThread(), "FirstThread");
        Thread secondThread = new Thread(new MyThread(), "SecondThread");
        firstThread.start();
        secondThread.start();
        System.out.println("Main Thread Name: " + Thread.currentThread().getName());
        System.out.println("Main Thread Id: " + Thread.currentThread().getId());
        System.out.println("Main Thread State: " + Thread.currentThread().getState());
        System.out.println("Main Thread Priority: " + Thread.currentThread().getPriority());
    }
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Name: " + Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName()+" Thread Id: " + Thread.currentThread().getId());
            System.out.println(Thread.currentThread().getName()+" State: " + Thread.currentThread().getState());
            System.out.println(Thread.currentThread().getName()+" Priority: " + Thread.currentThread().getPriority());
        }
    }
}
