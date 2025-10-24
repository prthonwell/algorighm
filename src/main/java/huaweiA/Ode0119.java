package huaweiA;

import java.util.*;

public class Ode0119 {

    public class segment {
        static int[] sum;

        segment(int[] arr) {
            int len = arr.length;
            sum = new int[len << 2];
            for (int i = 0; i < len; i++) {
                segment.add(0, len, i, arr[i], 0);
            }
        }

        static void add (int l, int r, int i, int v, int cur) {
            if (l == r) {
                sum[cur] += v;
                return;
            }

            int mid = l + (r - l) / 2;
            int left = cur * 2 + 1;
            int right = cur * 2 + 2;

            if (i < mid) {
                add(l, mid - 1, i, v, left);
            } else {
                add(mid, r, i, v, right);
            }

            sum[cur] += v;
        }

        static void sub (int l, int r, int i, int v, int cur) {
            if (l == r) {
                sum[cur] -= v;
                return;
            }
            int mid = l + (r - l) / 2;
            int left = cur * 2 + 1;
            int right = cur * 2 + 2;
            if (i < mid) {
                sub(l, mid - 1, i, v, left);
            } else {
                sub(mid, r, i, v, right);
            }
            sum[cur] -= v;
        }

        static Integer query (int l, int r, int start, int end, int cur) {
            if (end < start) {
                return 0;
            }
            if (l == r) {
                return sum[cur];
            }

            int mid = l + (r - l) / 2;
            int left = cur * 2 + 1;
            int right = cur * 2 + 2;

            int res = 0;
            if (start < mid && end >= mid) {
                res += query(l, mid - 1, start, mid - 1, left);
                res += query(mid, r, mid, end, right);
            } else if (end < mid) {
                res += query(l, mid - 1, start, end, left);
            } else {
                res += query(mid, r, mid, start, right);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        String[] ss = s.split("-");
        StringBuilder sb = new StringBuilder();
        sb.append(ss[0]);
        String join = String.join("", ss).toUpperCase();
        int count = n;
        for (int i = ss[0].length(); i < join.length(); i++) {
            if (count == n) {
                sb.append("-");
                count = 0;
            }
            sb.append(join.charAt(i));
            count++;
        }
        System.out.println(sb.toString());
    }
}
