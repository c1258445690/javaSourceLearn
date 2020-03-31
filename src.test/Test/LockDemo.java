package Test;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(LockDemo::exeucte).start();
        }
    }

    public static void exeucte() {
        lock.lock();
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
