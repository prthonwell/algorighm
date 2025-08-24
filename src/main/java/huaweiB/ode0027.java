package huaweiB;

import java.util.*;

public class ode0027 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> juXing = new ArrayList<>(); // 左右上下
        for (int i = 0; i < 3; i++) {
            int[] cur = Arrays.stream( sc.nextLine().split(" ") ).mapToInt( Integer::parseInt ).toArray();
            if (cur[0] < -1000 || cur[1] < -1000
                    || cur[0] >= 1000 || cur[1] >= 1000
                    || cur[2] < 0 || cur[3] < 0) {
                System.out.println(0);
                return;
            }
            juXing.add(new int[] { cur[0], cur[0] + cur[2], cur[1], cur[1] - cur[3]});
        }
        int[] res = new int[4];
        res[0] = Integer.MIN_VALUE;
        res[1] = Integer.MAX_VALUE;
        res[2] = Integer.MAX_VALUE;
        res[3] = Integer.MIN_VALUE;
        for (int i = 0; i < juXing.size(); i++) {
            res[0] = Math.max(res[0], juXing.get(i)[0]);
            res[1] = Math.min(res[1], juXing.get(i)[1]);
            res[2] = Math.min(res[2], juXing.get(i)[2]);
            res[3] = Math.max(res[3], juXing.get(i)[3]);
        }
        int w = (res[1] - res[0]) ;
        if (w < 0) {
            System.out.println(0);
            return;
        }
        int h = (res[2] - res[3]) ;
        if (h < 0) {
            System.out.println(0);
            return;
        }
        System.out.println(w * h);
        sc.close();
    }

}
