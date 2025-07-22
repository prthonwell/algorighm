package ob;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("线程A被LockSupport.park()阻塞");
                LockSupport.park();

                System.out.println("线程A被线程B LockSupport.unpark()唤醒");

            }
        },"A");

        t.start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程B唤醒线程A");
                // 唤醒指定线程t，也就是A
                LockSupport.unpark(t);
            }
        },"B").start();
    }
}