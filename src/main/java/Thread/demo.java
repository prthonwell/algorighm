package Thread;

import java.time.Instant;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class demo {
    public static void main(String[] args) {
        ExecutorServiceCalculator calculator = new ExecutorServiceCalculator();
        int[] array = IntStream.rangeClosed(1, 10000).toArray();
        Instant start = Instant.now();
        long res = calculator.sum(array);
        Instant end = Instant.now();
        System.out.println("cost time:" + (end.toEpochMilli() - start.toEpochMilli()) + "   res: " + res);
    }
}
