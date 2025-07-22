package from41to50;

import java.util.Stack;

class Trap {
    // https://leetcode.cn/problems/trapping-rain-water/ 41
    public int trap(int[] height) {
        int index = 0;
        int rightSum = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[index]) {
                index = i;
            } else {
                rightSum += height[index] - height[i];
            }
        }
        int highPoint = height[index];
        int highest = index;
        index = height.length - 1;
        int leftSum = height[index] - highPoint;
        for (int i = height.length - 2; i > highest; i--) {
            if (height[i] > height[index]) {
                index = i;
            }
            leftSum -= highPoint - height[index];
        }
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Trap().trap(height));
    }
}