package lock;

import java.util.concurrent.*;

public class futureTest {

    private static ExecutorService pool = Executors.newSingleThreadExecutor();

    private static Future<String> Test (String a) {
        return pool.submit(() -> {
            System.out.println("start");
            Thread.sleep(1000);
            return a + a;
        });
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Future<String> future = Test("A");
        while (!future.isDone()) {
            System.out.println("not ready");
            Thread.sleep(300);
        }
        System.out.println(future.get());
        pool.shutdown();
    }
}
