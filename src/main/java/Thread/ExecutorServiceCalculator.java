package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceCalculator {
    private int runnerCount;
    private ExecutorService pool;

    public ExecutorServiceCalculator() {
        runnerCount = Runtime.getRuntime().availableProcessors();
        pool = Executors.newFixedThreadPool(runnerCount);
    }

    public static class sumTask implements Callable<Long> {
        private int[] array;
        private int start;
        private int end;


        public sumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public Long call() throws Exception {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        }
    }

    public long sum(int[] array) {
        List<Future<Long>> resultList = new ArrayList<>();
        int n = array.length;
        int segment = n / runnerCount;
        for (int i = 0; i < runnerCount; i++) {
            Future future = pool.submit(new sumTask(array, i * segment, (i == runnerCount - 1 ? n : (i + 1) *segment)));
            resultList.add(future);
        }
        long sum = 0;
        for (Future<Long> future : resultList) {
            try {
                sum += future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return sum;
    }
}
