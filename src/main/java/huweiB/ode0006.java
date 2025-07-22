package huweiB;

import java.util.*;

public class ode0006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[] a = new int[M];
        for (int i = 0; i < M; i++) {
            a[i] = sc.nextInt();
        }
        int K = sc.nextInt();
        if (K == M) {
            System.out.println(N);
            return;
        }
        int index = 1;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            if (a[i] == index) index++;
            else {
                list.add(new int[] { index, a[i], a[i] - index});
                index = a[i] + 1;
            }
        }
        if (index != N + 1) {
            list.add(new int[] { index, N + 1, N - index + 1});
        }
        index = 0; int index2 = 1, res = list.get(0)[2], len = res;
        while (index2 < list.size() && K >= list.get(index2)[0] - list.get(index2 - 1)[1]) {
            int split = list.get(index2)[0] - list.get(index2 - 1)[1];
            K -= split;
            len += list.get(index2)[2] + split;
            index2++;
        }
        res = len;
        while (index2 < list.size()) {
            int s = list.get(index + 1)[0] - list.get(index)[1];
            len -= list.get(index)[2] + s;
            K += s;
            index++;
            while (index2 < list.size() && K >= list.get(index2)[0] - list.get(index2 - 1)[1]) {
                int split = list.get(index2)[0] - list.get(index2 - 1)[1];
                K -= split;
                len += list.get(index2)[2] + split;
                index2++;
            }
            res = Math.max(res, len);
        }
        System.out.println(res);
        sc.close();
    }
}
