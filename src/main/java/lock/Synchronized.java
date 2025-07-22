package lock;

import com.sun.tools.javac.Main;

public class Synchronized {
    static Integer num = 0;
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread T = new Thread(new Runnable() {
                @Override
                public void run() {
                    // 悲观锁 所有操作都被线程0执行
                    synchronized (Main.class) {
                        while (num < 1000) {
                            System.out.println("thread name: " + Thread.currentThread().getName() + "__________" + num++);
                        }
                    }
                }
            });
            T.start();
        }
    }
}
