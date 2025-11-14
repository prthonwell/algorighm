package huaweiB;

import java.util.*;

public class odb0068 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numStr = sc.nextLine().split(" ");
        int n = numStr.length;
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(numStr[i]);
        }
        Arrays.sort(num);
        int max = num[n - 1] + num[0], min = num[n - 1];
        for (int i = min; i <= max; i++) {
            int h = 0, l = 0, r = n - 1;
            while (l <= r && num[r] == i) {
                r--;
                h++;
            }
            while (l < r && num[l] + num[r] == i) {
                l++;
                r--;
                h++;
            }
            if (l > r) {
                System.out.println(h);
                return;
            }
        }
        System.out.println(-1);
    }
}
