package thread;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQuene<T> {

    //阻塞队列
    private Deque<T> quene = new ArrayDeque<>();

    //容量大小
    private int capcity;

    //锁
    private ReentrantLock lock = new ReentrantLock();

    //消费者等待
    private Condition consumerAwait = lock.newCondition();

    //生产者等待
    private Condition producerAwait = lock.newCondition();

    public BlockingQuene(int capcity) {
        this.capcity = capcity;
    }

    //超时控制
    public T poll(long timeout, TimeUnit timeUnit) {
        lock.lock();
        try {
            long nanos = timeUnit.toNanos(timeout);
            while (quene.isEmpty()) {
                try {
                    if (nanos < 0) {
                        return null;
                    }
                    nanos = consumerAwait.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T elemnet = quene.removeFirst();
            producerAwait.signalAll();
            return elemnet;
        } finally {
            lock.unlock();
        }
    }

    //取出元素
    public T take() {
        lock.lock();
        try {
            while (quene.isEmpty()) {
                try {
                    consumerAwait.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T elemnet = quene.removeFirst();
            producerAwait.signalAll();
            return elemnet;
        } finally {
            lock.unlock();
        }
    }

    //添加元素
    public void put(T element) {
        lock.lock();
        try {
            while (quene.size() == capcity) {
                try {
                    producerAwait.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            quene.addLast(element);
            consumerAwait.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return quene.size();
        } finally {
            lock.unlock();
        }
    }

    public void tryput(RejectPolicy<T> rejectPolicy, T task) {
    }
}

interface RejectPolicy<T> {
    void reject(BlockingQuene<T> quene, T task);
}
