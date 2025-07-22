package lock;

import java.util.concurrent.locks.LockSupport;

public class test {
    private static int a = 0;
    private static MyLock MLock = new MyLock();

    private static void increment() {
        MLock.lock();
        try {
            a++;
        }finally {
            MLock.unlock();
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    increment();
                }
            }).start();
        }
        LockSupport.parkNanos(3*1000*1000*1000L);
        System.out.println(a);
    }
}
