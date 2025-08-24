package leetCode.from51to60;

import java.util.ArrayList;
import java.util.List;

class SpiralOrder {
    //https://leetcode.cn/problems/spiral-matrix/ 54
    public List<Integer> spiralOrder(int[][] matrix) {
        int bottom = matrix.length - 1;
        int top = 0;
        int right = matrix[0].length - 1;
        int left = 0;
        List<Integer> result = new ArrayList<Integer>();
        while (true) {
            for (int i = left; i <= right; i++) result.add(matrix[top][i]);
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) result.add(matrix[i][right]);
            if (--right < left) break;
            for (int i = right; i >= left; i--) result.add(matrix[bottom][i]);
            if (--bottom < top) break;
            for (int i = bottom; i >= top; i--) result.add(matrix[i][left]);
            if (++left > right) break;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20},{21,22,23,24}};
        SpiralOrder spiralOrder = new SpiralOrder();
        List<Integer> result = spiralOrder.spiralOrder(matrix);
    }
}