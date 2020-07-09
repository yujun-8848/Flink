import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    //阻塞队列
    private BlockingQuene<Runnable> taskQuene;

    //核心数
    private int coreSize;
    //线程集合
    private final Set<Worker> workers = new HashSet<>();

    //时间转换
    private TimeUnit timeUnit;
    //超时时间
    private long timeout;

    private RejectPolicy<Runnable> rejectPolicy;

    public ThreadPool(int coreSize, TimeUnit timeUnit, long timeout, int queneCapticy, RejectPolicy rejectPolicy) {
        this.coreSize = coreSize;
        this.timeUnit = timeUnit;
        this.timeout = timeout;
        this.rejectPolicy = rejectPolicy;
        this.taskQuene = new BlockingQuene<>(queneCapticy);
    }

    public void excute(Runnable task) {
        synchronized (workers) {
            if (workers.size() < coreSize) {
                Worker worker = new Worker(task);
                System.out.printf("新增worker{%s}", worker);
                System.out.println();
                workers.add(worker);
                worker.start();
            } else {
                System.out.printf("加入任务队列%s", task);
                System.out.println();
                // taskQuene.put(task);
                taskQuene.tryput(rejectPolicy, task);
            }
        }
    }

    class Worker extends Thread {

        private Runnable task;


        public Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {

            while (task != null || (task = taskQuene.poll(timeout, timeUnit)) != null) {
                try {
                    System.out.printf("正在执行{%s}", task);
                    System.out.println();
                    task.run();
                } catch (Exception e) {

                } finally {
                    task = null;
                }
            }
            synchronized (workers) {
                System.out.printf("worker被移除%s", this);
                System.out.println();
                workers.remove(this);
            }
        }
    }

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(1, TimeUnit.MILLISECONDS, 1000, 1, (quene, task) -> {
            System.out.println("放弃" + task);
        });
        for (int i = 0; i < 3; i++) {
            int j = i;
            threadPool.excute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("{%s}", j);
                System.out.println();
            });
        }
    }




}

