package huaweiA;
import java.util.*;

public class Ode0123 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] order = new int[m];
        for (int i = 0; i < m; i++) {
            order[i] = sc.nextInt();
        }
        sc.nextLine();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        Arrays.sort(matrix, (a, b) -> {
            int res;
            for (int i = 0; i < m; i++) {
                if (order[i] == 1) {
                    res = Integer.compare(b[i], a[i]);
                } else {
                    res = Integer.compare(a[i], b[i]);
                }
                if (res != 0) {
                    return res;
                }
            }
            return 0;
        });

        for (int[] cur : matrix) {
            StringJoiner sj = new StringJoiner(" ");
            for (int i = 0; i < m; i++) {
                sj.add(cur[i] + "");
            }
            System.out.println(sj);
        }
    }
}
