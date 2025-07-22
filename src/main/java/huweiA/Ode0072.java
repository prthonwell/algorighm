package huweiA;

import java.util.*;

public class Ode0072 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int num = sc.nextInt();
        int target = sc.nextInt();
        sc.close();
        String[] ss = s.split(" ");
        int n = ss.length;
        if (n < num) {
            System.out.println(0);
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }
        Arrays.sort(arr);
        int res = search(arr, target, num, 0);
        System.out.println(res);
    }

    private static int search(int[] arr, long target, int num, int index) {
        if (num == 2) {
            int res = 0;
            int l = index, r = arr.length - 1;
            while (l < r) {
                if (arr[l] + arr[r] == target) {
                    res++;
                    while (l < r && arr[l] + arr[r] == target) l++;
                } else if (arr[l] + arr[r] < target) {
                    l++;
                } else {
                    r--;
                }
            }
            return res;
        }
        int res = 0;
        for (int i = index; i < arr.length - num; i++) {
            if (target < (long) arr[i] * num) break;
            if (i > index && arr[i] == arr[i - 1]) continue;
            res += search(arr, target - arr[i], num - 1, i + 1);
        }
        return res;
    }
}
