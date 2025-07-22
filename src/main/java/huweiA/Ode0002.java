package huweiA;

import java.util.*;

public class Ode0002 {

    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int n = s1.length();
        int m = s2.length();
        boolean[][] arr = new boolean[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = s2.charAt(i) == s1.charAt(j);
            }
        }
        int[] res = new int[2]; // 0 比较字符串的其实位置  1 长度
        for (int offset = 0; offset < n; offset++) {
            for (int i = 0; i < m && i + offset < n; i++) {
                int j = i + offset;
                if (arr[i][j] && !visited[i][j]) {
                    visited[i][j] = true;
                    int len = 1;
                    while (i + len < m && j + len < n && arr[i + len][j + len]) {
                        visited[i + len][j + len] = true;
                        len++;
                    }
                    if (len > res[1]) {
                        res[0] = i;
                        res[1] = len;
                    }
                }
            }
        }
        for (int offset = 0; offset < m; offset++) {
            for (int i = 0; i < n && i + offset < m; i++) {
                int j = i + offset;
                if (arr[j][i] && !visited[j][i]) {
                    visited[j][i] = true;
                    int len = 1;
                    while (j + len < m && i + len < n && arr[j + len][i + len]) {
                        visited[j + len][i + len] = true;
                        len++;
                    }
                    if (len > res[1]) {
                        res[0] = j;
                        res[1] = len;
                    }
                }
            }
        }
        System.out.println(s2.substring(res[0], res[1] + res[0]));
    }
}