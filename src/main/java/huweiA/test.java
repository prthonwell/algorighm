package huweiA;

import java.util.Arrays;
import java.util.Scanner;
/**
 * @author code5bug
 */
public class test {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        // 读取地图高度数组
        int[] heights = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = heights.length;
        int power = scanner.nextInt();
 
        // 初始化数组用于记录从左侧最近的地面到当前位置的向上和向下的总高度差
        int[] leftUp = new int[n + 1];
        int[] leftDown = new int[n + 1];
        Arrays.fill(leftUp, Integer.MAX_VALUE);
        Arrays.fill(leftDown, Integer.MAX_VALUE);
 
        int prevHeight = -1;
        // 从左向右遍历地图，计算左侧最近的地面到当前位置的向上和向下的总高度差
        for (int i = 1; i <= n; i++) {
            int curHeight = heights[i - 1];
            if (curHeight == 0) {
                leftUp[i] = 0;
                leftDown[i] = 0;
            } else if (leftUp[i - 1] != Integer.MAX_VALUE) {
                int d = Math.abs(curHeight - prevHeight);
                if (curHeight >= prevHeight) {
                    leftUp[i] = leftUp[i - 1] + d;
                    leftDown[i] = leftDown[i - 1];
                } else {
                    leftUp[i] = leftUp[i - 1];
                    leftDown[i] = leftDown[i - 1] + d;
                }
            }
            prevHeight = curHeight;
        }
 
        int peakCount = 0;
 
        // 初始化变量用于记录从右侧最近的地面到当前位置的向上和向下的总高度差
        int rightUp = Integer.MAX_VALUE;
        int rightDown = Integer.MAX_VALUE;
        // 从右向左遍历地图
        for (int r = n - 1; r >= 0; r--) {
            if (heights[r] == 0) {
                rightUp = 0;
                rightDown = 0;
            } else if (rightUp != Integer.MAX_VALUE) {
                int d = Math.abs(heights[r] - heights[r + 1]);
                if (heights[r] > heights[r + 1]) {
                    rightUp += d;
                } else {
                    rightDown += d;
                }
            }
 
            // 当前位置为峰值时，计算上山和下山的最小体力消耗，并判断是否满足攀登者的体力条件
            if ((r == 0 || heights[r - 1] < heights[r]) && (r + 1 == n || heights[r] > heights[r + 1])) {
                int minUpCost = Integer.MAX_VALUE;
                int minDownCost = Integer.MAX_VALUE;
                if (leftUp[r + 1] != Integer.MAX_VALUE) {
                    minUpCost = Math.min(leftUp[r + 1] * 2 + leftDown[r + 1], minUpCost);
                    minDownCost = Math.min(leftUp[r + 1] + leftDown[r + 1] * 2, minDownCost);
                }
                if (rightUp != Integer.MAX_VALUE) {
                    minUpCost = Math.min(minUpCost, rightUp * 2 + rightDown);
                    minDownCost = Math.min(minDownCost, rightUp + rightDown * 2);
                }
 
                if (minUpCost != Integer.MAX_VALUE && minUpCost + minDownCost < power) {
                    // System.out.println(r + "可安全到达");
                    peakCount++;
                }
            }
        }
 
        // 输出满足条件的峰值个数
        System.out.println(peakCount);
    }
}