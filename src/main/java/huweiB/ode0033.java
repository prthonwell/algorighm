package huweiB;

import java.util.*;
import java.util.regex.Pattern;

public class ode0033 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = Arrays.stream( sc.nextLine().split(" ")).mapToInt( Integer::parseInt ).toArray();
        int[] res = new int[1];
        dfs(a, 1, res, a[0]);
        dfs(a, 2, res, a[0]);
        System.out.println(res[0]);
        sc.close();
    }

    private static void dfs(int[] a, int i, int[] res, int path) {
        if (i > a.length - 1 || a[i] == -1) {
            res[0] = Math.max( res[0], path );
            return;
        }
        dfs(a, i * 2 + 1, res, path + a[i]);
        dfs(a, i * 2 + 2, res, path + a[i]);
    }
}
