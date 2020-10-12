package thread;

import java.util.concurrent.TimeUnit;

public class SleepBlocked implements Runnable{


    public void run() {

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting thread.SleepBlocked.run()");
    }
}
