package thread;

public class SynchronizedBlocked implements Runnable {


    public synchronized  void f(){
        while (true){
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        new Thread(new Runnable() {
            public void run() {
                f();
            }
        }).start();
    }

    public void run(){
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting thread.SynchronizedBlocked.run()");
    }
}
