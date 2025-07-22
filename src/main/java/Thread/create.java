package Thread;

import java.util.HashMap;

public class create {
    public static int a;
    private static void test() {}
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println(a);
            }
        });

        create a = new create();
        new Thread(() -> {
            a.test();
        }).start();
    }
}
