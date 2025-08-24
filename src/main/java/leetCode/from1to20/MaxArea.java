package leetCode.from1to20;

import java.util.ArrayList;
import java.util.List;

public class MaxArea {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1, res = 0;
        while (l < r) {
            res = Math.max(res, (r - l) * Math.min(height[l], height[r]));
            if (height[l] <= height[r]) {
                int pre = height[l];
                while (l < r && height[l] <= pre) {
                    l++;
                }
            } else {
                int pre = height[r];
                while (r > l && height[r] <= pre) {
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
