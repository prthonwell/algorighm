package from41to50;

class Rotate {
    // https://leetcode.cn/problems/rotate-image/ 48
    public void rotate(int[][] matrix) {
        int R = matrix.length;
        int L = 0;
        while (L < R) {
            for (int i = 0; i < R - L - 1; i++){
                int temp = matrix[L][L + i];
                matrix[L][L + i] = matrix[R - 1 - i][L];
                matrix[R - 1 - i][L] = matrix[R - 1][R - 1 - i];
                matrix[R - 1][R - 1 - i] = matrix[L + i][R - 1];
                matrix[L + i][R - 1] = temp;
            }
            L++;
            R--;
        }
    }
}