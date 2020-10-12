package thread;

import java.io.IOException;
import java.io.InputStream;

public class IOBloced implements Runnable {
    private InputStream in;

    public IOBloced(InputStream in) {
        this.in = in;
    }

    public void run() {

        try {
            System.out.println("Waitting for read():");
            in.read();
        } catch (IOException e) {
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Interrupted from blocked I/O");
            }else {
                throw new RuntimeException();
            }

        }
        System.out.println("Exiting IOBlocked.run()");
    }
}
