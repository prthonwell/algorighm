package huweiB;

import java.util.*;

public class odb0063 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for ( int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            list.add( new int[] {a, b});
        }

        HashSet<int[]> set = new HashSet<>(list);
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int res = 0;
        while (!set.isEmpty()) {
            res++;
            int count = 0, right = 0;
            for (int[] a : list) {
                if (a[0] < right) continue;
                if (!set.contains(a)) continue;
                count++;
                set.remove(a);
                right = a[1];
                if (count == m) {
                    break;
                }
            }
        }
        System.out.println(res);
        sc.close();
    }
}
