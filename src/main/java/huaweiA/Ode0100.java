package huaweiA;

import java.util.*;

public class Ode0100 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        list.stream().distinct().sorted().forEach(System.out::println);
    }
}
