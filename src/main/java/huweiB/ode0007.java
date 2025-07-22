package huweiB;

import java.util.*;

public class ode0007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split(";");
        int[] times = Arrays.stream(ss[3].split(",")).mapToInt( Integer::parseInt ).toArray();
        double[] b = Arrays.stream(ss[4].split(",")).mapToDouble( Double::parseDouble ).toArray();
        String[] compare = ss[5].split(",");
        boolean flag = true;
        double res = Double.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            double[] cur = Arrays.stream(ss[i].split(",")).mapToDouble( Double::parseDouble ).toArray();
            double sum = 0;
            for (int j = 0; j < 5; j++) {
                sum += cur[j] * times[j];
            }
            if (compare[i].equals("<")) flag &= sum < b[i];
            else if (compare[i].equals(">")) flag &= sum > b[i];
            else if (compare[i].equals("<=")) flag &= sum <= b[i];
            else if (compare[i].equals(">=")) flag &= sum >= b[i];
            else if (compare[i].equals("=")) flag &= sum == b[i];
            res = Math.max(res, sum - b[i]);
        }
        System.out.println(flag + " " + (int)res);
        sc.close();
    }
}
