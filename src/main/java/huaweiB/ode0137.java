package huaweiB;

import java.util.*;

public class ode0137 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toList();
        int n = list.size();
        sc.close();
        int sum = 0, r = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int num = list.get(i);
            if (num > sum) {
                res[r++] = num;
            } else {
                int l = 0;
                int cur = sum;
                while (cur > num) {
                    cur -= res[l++];
                }
                if (cur == num) {
                    res[l] = num * 2;
                    r = l + 1;
                } else {
                    res[r++] = num;
                }
            }
            sum += num;
        }
        StringJoiner sj = new StringJoiner(" ");
        for (int i = r - 1; i >= 0; i--) {
            sj.add(res[i] + "");
        }
        System.out.println(sj.toString());
    }

}
