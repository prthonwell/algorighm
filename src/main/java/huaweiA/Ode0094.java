package huaweiA;

import java.util.*;

public class Ode0094 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort( arr );
        List<Integer> list = Arrays.stream(arr).boxed().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - m) - Math.abs(o2 - m);
            }
        }).toList();
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
