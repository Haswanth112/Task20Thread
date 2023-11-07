
public class ThreadRef {
    public static void main(String[] args) {
        System.out.println("Name: "+Thread.currentThread().getName());
        System.out.println("Thread Id: "+Thread.currentThread().threadId());
        System.out.println("State: "+Thread.currentThread().getState());
        System.out.println("Priority: "+Thread.currentThread().getPriority());
    }
}
