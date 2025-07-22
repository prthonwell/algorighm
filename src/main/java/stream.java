import com.sun.jdi.IntegerValue;

import java.util.*;
import java.util.stream.Collectors;

public class stream {
    public static void main(String[] args) {
//        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//        List<String> filtered = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
//        filtered.forEach(System.out::println);

        List<Integer> Integers = Arrays.asList(1, 0, 7, 0, 5, 4, 7);
        int[] sum = Integers.stream().filter(i -> i >= 3).sorted().mapToInt(i -> i).toArray();
        Arrays.stream(sum).forEach(System.out::println);
        Integer[] sum2 = Arrays.stream(sum).boxed().sorted().toArray(Integer[]::new);
        List<Integer> Integers1 = Arrays.stream(sum2).toList();

        Integer[] intArray = new Integer[]{1, 2, 3};
        List<Integer> list = Arrays.stream(intArray).collect(Collectors.toList());
        list.add(4); // 允许操作
        list.forEach(System.out::println);


        Integer[] integerArray = {1, 2, 3, 4, 5};
        int[] intArray2 = Arrays.stream(integerArray).mapToInt(Integer::intValue).toArray();

        // 输出转换后的 int 数组
        System.out.println(Arrays.toString(intArray2));

//        Random random = new Random();
//        random.ints().limit(strings.size()).forEach(System.out::println);
    }
}
