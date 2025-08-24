package leetCode.from41to50;

class Rotate {
    // https://leetcode.cn/problems/rotate-image/ 48
    public void rotate(int[][] matrix) {
        int r = matrix.length - 1, l = 0;
        while (r - l > 0) {
            for (int offset = 0; offset < r - l; offset++) {
                int temp = matrix[l][l + offset];
                matrix[l][l + offset] = matrix[r - offset][l];
                matrix[r - offset][l] = matrix[r][r - offset];
                matrix[r][r - offset] = matrix[l + offset][r];
                matrix[l + offset][r] = temp;
            }
            r--;
            l++;
        }

    }

//    int R = matrix.length;
//    int L = 0;
//        while (L < R) {
//        for (int i = 0; i < R - L - 1; i++){
//            int temp = matrix[L][L + i];
//            matrix[L][L + i] = matrix[R - 1 - i][L];
//            matrix[R - 1 - i][L] = matrix[R - 1][R - 1 - i];
//            matrix[R - 1][R - 1 - i] = matrix[L + i][R - 1];
//            matrix[L + i][R - 1] = temp;
//        }
//        L++;
//        R--;
//    }
}