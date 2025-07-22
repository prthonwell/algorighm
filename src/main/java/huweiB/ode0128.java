package huweiB;

import java.util.*;

public class ode0128 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        if (n < 3 || n > 10 || m < 3 || m > 100) {
            System.out.println(-1);
            sc.close();
            return;
        }
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            List<Integer> nums = Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).toList();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = nums.get(j);
                if (matrix[i][j] < 0 || matrix[i][j] > 10) {
                    System.out.println(-1);
                    sc.close();
                    return;
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                cur.add(matrix[j][i]);
            }
            cur.sort((a, b) -> b - a);
            cur.add(i + 1);
            res.add(cur);
        }
        res.sort( new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int sum1 = 0;
                int sum2 = 0;
                for (int i = 0; i < o1.size() - 1; i++) {
                    sum1 += o1.get(i);
                    sum2 += o2.get(i);
                }
                if (sum1 != sum2) {
                    return sum2 - sum1;
                }
                int index = 0;
                while (index < o1.size() - 1) {
                    if (!Objects.equals(o1.get(index), o2.get(index))) {
                        return o2.get(index) - o1.get(index);
                    }
                    index++;
                }
                return 0;
            }
        });
        StringJoiner sj = new StringJoiner(",");
        for (int i = 0; i < 3; i++) {
            sj.add(res.get(i).get(n) + "");
        }
        System.out.println(sj.toString());
        sc.close();
    }
}
