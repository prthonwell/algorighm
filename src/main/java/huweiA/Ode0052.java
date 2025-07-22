package huweiA;

import java.util.*;

public class Ode0052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        String[] ss = s.split(",");
        int M = ss.length;
        int[] loads = new int[M];
        int right = 0, left = 0;
        for (int i = 0; i < M; i++) {
            loads[i] = Integer.parseInt(ss[i]);
            right += loads[i];
        }
        Arrays.sort(loads);
        for (int i = 0; i < M / 2; i++) {
            int temp = loads[i];
            loads[i] = loads[M - i - 1];
            loads[M - i - 1] = temp;
        }
        while (left < right) {
            int target = left + (right - left) / 2;
            if (contained(target, new int[n], loads, 0)) {
                right = target;
            } else {
                left = target + 1;
            }
        }
        System.out.println(left);
    }

    private static boolean contained(int target, int[] workers, int[] loads, int i) {
        if (i == loads.length) {
            return true;
        }
        for (int j = 0; j < workers.length; j++) {
            if (j > 0 && workers[j] == workers[j - 1]) {
                continue;
            }
            if (workers[j] + loads[i] <= target) {
                workers[j] = workers[j] + loads[i];
                if (contained(target, workers, loads, i + 1)) {
                    return true;
                }
                workers[j] = workers[j] - loads[i];
            }
            if (workers[j] == 0) {
                break;
            }
        }
        return false;
    }
}
