package Thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinerPoolCalculator {
    private ForkJoinPool pool;

    public class sumTask extends RecursiveTask<Long> {

        int[] array;
        int start;
        int end;

        public sumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= 100) {
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                int middle = (start + end) / 2;
                ForkJoinTask<Long> left = new sumTask(array, start, middle);
                ForkJoinTask<Long> right = new sumTask(array, middle + 1, end);
                left.fork();
                right.fork();
                return left.join() + right.join();
            }
        }


    }

    public ForkJoinerPoolCalculator() {
        pool = new ForkJoinPool();
    }

    public long sum(int[] array, int start, int end) {
        ForkJoinTask<Long> task = new sumTask(array, start, end);
        return pool.invoke(task);
    }
}
