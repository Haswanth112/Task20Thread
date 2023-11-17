class SharedResource {
    private static final String[] words = {
            "Java",
            "is",
            "object-oriented,",
            "open source,",
            "easy to learn,",
            "high performance",
            "and,",
            "fast."
    };
    private static int index = 0;
    synchronized static String getNextWord() {
        if (index < words.length) {
            return words[index++];
        }
        return null;
    }
}

class MyThread1 extends Thread {
    public void run() {
        String word;
        while ((word = SharedResource.getNextWord()) != null) {
            System.out.println(Thread.currentThread().getName() + ": " + word);
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " is dead.");
    }
}

public class MultiThread {
    public static void main(String[] args) {
        Thread thread1 = new MyThread1();
        Thread thread2 = new MyThread1();
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Both threads are dead.");
    }
}
