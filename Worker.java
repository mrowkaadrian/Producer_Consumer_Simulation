import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

abstract class Worker extends Thread {

    public static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {

        }
    }

    public static void sleep(int min_millis, int max_milis){
        sleep(ThreadLocalRandom.current().nextInt(min_millis, max_milis));
    }

    static int itemID = 0;

    public static int MIN_PRODUCER_TIME = 100;
    public static int MAX_PRODUCER_TIME = 1000;

    public static int MIN_CONSUMER_TIME = 100;
    public static int MAX_CONSUMER_TIME = 1000;

    String name;
    Buffer buffer;
    JTextArea textArea;

    @Override
    public abstract void run();
}