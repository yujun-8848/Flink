package thread;

public class WaitNotify {

    //标记位
    private int flag;
    //循环次数
    private int Number;

    public WaitNotify(int flag, int number) {
        this.flag = flag;
        this.Number = number;
    }

    public void print(String strName,int waitFlag,int nextWaitFlag){
        for (int i = 0; i < Number; i++) {
            synchronized (this){
                while (flag != waitFlag){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(strName);
                flag = nextWaitFlag;
                this.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        WaitNotify waitNotify = new WaitNotify(1, 10);
        new Thread(() -> {
            waitNotify.print("a",1,2);
        }).start();
        new Thread(() -> {
            waitNotify.print("b",2,3);
        }).start();
        new Thread(() -> {
            waitNotify.print("c",3,1);
        }).start();
    }
}
