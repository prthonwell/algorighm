package huaweiB;

import java.util.*;

public class odb0061 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String substring = s.substring(2, s.length() - 2);
        String[] lines =  substring.split("],\\[");
        int n = lines.length;
        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            String[] nums = lines[i].split(",");
            int[] arr = new int[nums.length];
            for (int j = 0; j < nums.length; j++) {
                arr[j] = Integer.parseInt(nums[j]);
            }
            matrix[i] = arr;
        }
        int m = matrix[0].length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int biggest = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                biggest = Math.max(biggest, matrix[j][i]);
            }
            res = Math.min(res, biggest);
        }
        System.out.println(res);
    }

}
