import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class ParkUnpark {

    public static Thread t1;
    public static Thread t2;
    public static Thread t3;

    private int loopNumber;

    public ParkUnpark(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    public void print(String strName, Thread next) {
        for (int i = 0; i < loopNumber; i++) {
            LockSupport.park();
            System.out.print(strName);
            LockSupport.unpark(next);
        }
    }

    public static void main(String[] args) {
        ParkUnpark parkUnpark = new ParkUnpark(5);
        t1 = new Thread(() -> {
            parkUnpark.print("a", t2);
        });
        t2 = new Thread(() -> {
            parkUnpark.print("b", t3);
        });
        t3 = new Thread(() -> {
            parkUnpark.print("c", t1);
        });
        t1.start();
        t2.start();
        t3.start();

        LockSupport.unpark(t1);



    }
}
