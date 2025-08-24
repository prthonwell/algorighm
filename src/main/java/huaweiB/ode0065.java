package huaweiB;

import java.util.*;

public class ode0065 {

    static class feedback {
        int num;
        int back;
        int[] spec;
        feedback (int num, int back, int[] spec) {
            this.num = num;
            this.back = back;
            this.spec = spec;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 0 || n >= 100) {
            System.out.println("NA");
        }
        sc.nextLine();
        List<feedback> feedbacks = new ArrayList<feedback>();
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            int num = Integer.parseInt(line[0]);
            int back = (line[1].charAt(0) - '0') * 5 + (line[1].charAt(2) - '0');
            int[] spec = new int[10];
            for (int j = 0; j < 4; j++) {
                spec[line[0].charAt(j) - '0']++;
            }
            feedbacks.add(new feedback(num, back, spec));
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            if (check(feedbacks, i)) res.add(i);
            if (res.size() > 1) {
                System.out.println("NA");
                System.out.println(i);
                return;
            }
        }
        sc.close();
        System.out.println(res.get(0));
    }

    private static boolean check(List<feedback> feedbacks, int i) {
        for (feedback f : feedbacks) {
            int A = 0, B = 0;
            int[] spec = Arrays.copyOf(f.spec, 10);
            int num1 = f.num;
            int num2 = i;
            boolean[] used = new boolean[4];
            for (int j = 3; j >= 0; j--) {
                int a = num1 % 10;
                int b = num2 % 10;
                if (a == b) {
                    A++;
                    spec[b]--;
                    used[j] = true;
                }
                num1 /= 10;
                num2 /= 10;
            }
            num1 = f.num;
            num2 = i;
            for (int j = 3; j >= 0; j--) {
                if (used[j]) {
                    num1 /= 10;
                    num2 /= 10;
                    continue;
                }
                int a = num1 % 10;
                int b = num2 % 10;
                if (spec[b] > 0) {
                    B++;
                    spec[b]--;
                }
                num1 /= 10;
                num2 /= 10;
            }
            if (A * 5 + B != f.back) return false;
        }
        return true;
    }
}
