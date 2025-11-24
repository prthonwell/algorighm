package huaweiB;

import java.util.*;

public class odb0070 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numStrS = sc.nextLine().split(" ");
        int n = sc.nextInt();
        sc.close();
        int[] nums = Arrays.stream( numStrS ).mapToInt( Integer::parseInt ).toArray();
        int[] colors = new int[3];
        int start = 0, end = 0, res = 0;
        while (end - start <= n - 1 && end < nums.length) {
            colors[nums[end]]++;
            end++;
        }
        for (int i = 0; i < 3; i++) {
            res = Math.max(res, colors[i]);
        }
        if (n == nums.length) {
            System.out.println(res);
            return;
        }
        while (end < nums.length) {
            colors[nums[end]]++;
            colors[nums[start]]--;
            res = Math.max(res, colors[nums[end]]);
            start++;
            end++;
        }
        System.out.println(res);
    }
}
