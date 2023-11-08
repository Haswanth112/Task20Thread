class DisplayMessage extends Thread {
    private String Message;
    public DisplayMessage(String Message){
        this.Message=Message;
    }
    public void run() {
        System.out.println(Message);
    }
}

public class MultiThread{
    public static void main(String[] args) {
        DisplayMessage thread1 = new DisplayMessage("Java is object-oriented, open source");
        DisplayMessage thread2 = new DisplayMessage("easy to learn, high performance and fast.");

        thread1.start();
        thread2.start();
    }
}

