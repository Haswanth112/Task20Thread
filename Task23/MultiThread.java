class MyThread1 extends Thread {
    private String[] words;

    public MyThread1(String[] words) {
        this.words = words;
    }

    @Override
    public void run() {
        for (String word : words) {
            System.out.println(Thread.currentThread().getName() + ": " + word);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " is dead.");
    }
}

public class MultiThread {
    public static void main(String[] args) {
        String[] thread1Words = {"Java", "high", "performance", "and", "fast."};
        String[] thread2Words = {"is", "object-oriented,", "open source,", "easy to learn,", "and"};

        MyThread1 thread1 = new MyThread1(thread1Words);
        MyThread1 thread2 = new MyThread1(thread2Words);

        thread1.setName("Thread1");
        thread2.setName("Thread2");

        thread1.start();
        thread2.start();
    }
}
