package huaweiA;

import java.util.*;

public class Ode0074 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.trim().isEmpty()) break;
            String[] ss = s.trim().split(" ");
            int n = ss.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(ss[i]);
            }
            list.add(arr);
        }
        list.sort( (a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1] );
        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
        }
    }
}
