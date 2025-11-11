package huaweiA;

import java.util.*;

public class Ode0122 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = split(n);
        System.out.println(res[0] + " " + res[1]);
    }

    public static int[] split(int n) {
        if (n == 1 || n == 2) {
            return new int[] { 0, 1 };
        }
        int[] left = split(n / 2 + n % 2);
        int[] right = split(n / 2);
        return new int[] { left[0] + right[0] + 1, left[1] + right[1] };
    }
}
