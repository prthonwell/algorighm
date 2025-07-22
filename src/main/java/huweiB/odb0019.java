package huweiB;

import java.util.*;

public class odb0019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        int required = sc.nextInt();

        int[] requiredArr = new int[n + 1];
        for (int i = n; i >= 0; i--) {
            int cur = (1 << i);
            if (required < cur) continue;
            requiredArr[i] = required / cur;
            required %= cur;
        }

        int res = 0;

        while (deduce(arr, requiredArr)) {
            res++;
        }

        sc.close();
        System.out.println(res);
    }

    private static boolean deduce(int[] arr, int[] required) {
        int rest = 0;
        for (int j = arr.length - 1; j >= 0; j--) {
            rest <<= 1;
            if (arr[j] >= required[j] + rest) {
                arr[j] -= required[j] + rest;
                rest = 0;
            } else {
                rest = required[j] + rest - arr[j];
                arr[j] = 0;
                if (j == 0) {
                    int index = j + 1, val = 2, sum = 0;
                    while (index < arr.length) {
                        while (arr[index] > 0) {
                            sum += val;
                            arr[index]--;
                            if (sum >= rest) {
                                return true;
                            }
                        }
                        index++;
                        val<<=1;
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
