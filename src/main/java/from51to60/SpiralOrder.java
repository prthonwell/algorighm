package from51to60;

import java.util.ArrayList;
import java.util.List;

class SpiralOrder {
    //https://leetcode.cn/problems/spiral-matrix/ 54
    public List<Integer> spiralOrder(int[][] matrix) {
        int bottom = matrix.length;
        int top = 0;
        int right = matrix[0].length;
        int left = 0;
        List<Integer> result = new ArrayList<Integer>();
        while (top < bottom && left < right) {
            if (top + 1 == bottom && left + 1 == right) {
                result.add(matrix[top][left]);
            } else if (left + 1 == right) {
                for (int i = top; i < bottom; i++) {
                    result.add(matrix[i][left]);
                }
            } else if (top + 1 == bottom) {
                for (int i = left; i < right; i++) result.add(matrix[top][i]);
            } else {
                for (int i = left; i < right - 1; i++) {
                    result.add(matrix[top][i]);
                }
                for (int i = top; i < bottom - 1; i++) {
                    result.add(matrix[i][right - 1]);
                }
                for (int i = right - 1; i > left; i--) {
                    result.add(matrix[bottom - 1][i]);
                }
                for (int i = bottom - 1; i > top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            top++;
            bottom--;
            right--;
            left++;
        }
        return result;
    }
}