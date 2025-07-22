package from81to90;

import java.util.Stack;

class LargestRectangleArea {
    // https://leetcode.cn/problems/largest-rectangle-in-histogram/ 84
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int n = heights.length, r = 0, Pos, val;
        int[] stack = new int[n];
        for (int i = 0; i < heights.length; i++) {
            while (r > 0 && heights[stack[r - 1]] >= heights[i]) {
                val = heights[stack[--r]];
                Pos = r > 0 ? stack[r - 1] : -1;
                res = Math.max(res, val * (i - Pos - 1));
            }
            stack[r++] = i;
        }
        while (r > 0) {
            val = heights[stack[--r]];
            Pos = r > 0 ? stack[r - 1] : -1;
            res = Math.max(res, val * (n - Pos - 1));
        }
        return res;
    }

    public static void main(String[] args) {
        LargestRectangleArea lsr = new LargestRectangleArea();
        System.out.println(lsr.largestRectangleArea(new int[]{2,1,5,6,2,3}));;
    }
}