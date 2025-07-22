package huweiB;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class odb0016 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), prepared = sc.nextInt();
        int[] arr = new int[m];
        int max = 0;
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }
        int min = 0;
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (check(mid, arr, prepared)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        sc.close();
        System.out.println(min);
    }

    private static boolean check(int mid, int[] arr, int prepared) {
        for (int i = 0; i < arr.length; i++) {
            prepared -= arr[i];
            if (prepared < 0) {
                return false;
            }
            prepared += mid;
        }
        return true;
    }
}
