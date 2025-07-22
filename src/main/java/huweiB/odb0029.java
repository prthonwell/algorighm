package huweiB;

import java.util.*;

public class odb0029 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int j = sc.nextInt();
            if (j % 2 == 0) {
                even.add(j);
            } else {
                odd.add(j);
            }
        }
        int evenSize = even.size();
        // 记录之前匹配结果用于回退
        int[] evenMatches = new int[evenSize];

        int res = 0;
        for (int i = 0; i < odd.size(); i++) {
            // 每次只要找到一个就可以返回了
            // 如果占用了后面需要的值，evenMatches记录了结果，可以回退重新匹配
            // 复杂度奇数偶数数组长度的积
            if (find(odd.get(i), new boolean[evenSize], evenMatches, even)) {
                res++;
            }
        }
        sc.close();
        System.out.println(res);
    }

    private static boolean find(Integer odd, boolean[] used, int[] evenMatches, List<Integer> even) {
        for (int i = 0; i < even.size(); i++) {
            if (used[i]) continue;
            if (IsSu(even.get(i) + odd)) {
                used[i] = true;

                if (evenMatches[i] == 0 || find(evenMatches[i], used, evenMatches, even)) {
                    evenMatches[i] = odd;
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean IsSu(Integer cur) {
        if (cur == 1 || cur == 2|| cur == 3) return true;
        if (cur % 2 == 0) return false;
        for (int i = 3; i*i < cur; i+=2) {
            if (cur % i == 0) return false;
        }
        return true;
    }
}
