package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Interrupting {

    private static ExecutorService exec = Executors.newCachedThreadPool();
    static void test(Runnable r) throws InterruptedException {
        Future<?> f = exec.submit(r);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("thread.Interrupting" + r.getClass().getName());
        f.cancel(true);
        System.out.println("Interrupt sent to " + r.getClass().getName());

    }

    public static void main(String[] args) throws InterruptedException {
        test(new SleepBlocked());
        test(new IOBloced(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aborting with Systim.exit(0)");
        System.exit(0);




    }
}
