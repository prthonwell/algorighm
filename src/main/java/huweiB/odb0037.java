package huweiB;

import java.util.*;
import java.util.regex.Pattern;

public class odb0037 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] freeSpace = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            freeSpace[i] = sc.nextInt();
        }
        List<int[]> operation = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 1) {
                int[] min = new int[2]; // 0 剩下的资源 1 位置
                min[0] = Integer.MAX_VALUE;
                for (int j = 1; j <= n; j++) {
                    if (freeSpace[j] >= b && freeSpace[j] - b < min[0]) {
                        min[0] = freeSpace[j] - b;
                        min[1] = j;
                    }
                }
                result.add(min[1]);
                if (min[1] == 0) {
                    operation.add(new int[] { min[1], 0});
                } else {
                    freeSpace[min[1]] -= b;
                    operation.add(new int[] { min[1], b});
                }
            } else if (a == 2) {
                freeSpace[operation.get(b - 1)[0]] += operation.get(b - 1)[1];
            }
        }
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }
}
