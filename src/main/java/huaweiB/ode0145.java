package huaweiB;

import java.util.*;

public class ode0145 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int n = s.length();
        int[] nums = new int[4];
        Arrays.fill( nums, -n / 4);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'A') nums[0]++;
            else if (c == 'W') nums[1]++;
            else if (c == 'S') nums[2]++;
            else nums[3]++;
        }
        for (int i = 0; i < 4; i++) {
            nums[i] = Math.max(0, nums[i]);
        }
        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(s,nums,mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }

    private static boolean check(String s, int[] nums, int mid) {
        int index = 0;
        int[] cur = new int[4];
        while (index < mid - 1) {
            char c = s.charAt(index++);
            if (c == 'A') cur[0]++;
            else if (c == 'W') cur[1]++;
            else if (c == 'S') cur[2]++;
            else cur[3]++;
        }
        while (index < s.length()) {
            char c = s.charAt(index++);
            if (c == 'A') cur[0]++;
            else if (c == 'W') cur[1]++;
            else if (c == 'S') cur[2]++;
            else cur[3]++;
            if (compare(nums, cur)) return true;
            char last = s.charAt(index - mid);
            if (last == 'A') cur[0]--;
            else if (last == 'W') cur[1]--;
            else if (last == 'S') cur[2]--;
            else cur[3]--;
        }
        return false;
    }

    private static boolean compare(int[] nums, int[] cur) {
        for (int i = 0; i < 4; i++) {
            if (nums[i] > cur[i]) return false;
        }
        return true;
    }
}
