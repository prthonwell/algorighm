package lock;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CAS {
    // 使用Unsafe类取出的原子型的Integer
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (atomicInteger.get() < 1000) {
                        System.out.println(
                                "thread name: "
                                        + Thread.currentThread().getName()
                                        + ":"
                                        // CAS操作
                                        + atomicInteger.incrementAndGet());
                    }
                }

            });
            thread.start();
        }

    }
}
