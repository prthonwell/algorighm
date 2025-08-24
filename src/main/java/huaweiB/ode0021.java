package huaweiB;

import java.util.*;

public class ode0021 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt( Integer::parseInt ).toArray();
        int sum = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int[] res = new int[n];
        int count = 0, index = 0, num = 1;
        while (count < sum) {
            if (check(num)) {
                count++;
                res[index]++;
            }
            index = (index + 1 + n) % n;
            num++;
        }
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < n; i++) {
            sj.add(String.valueOf(res[i]));
        }
        System.out.println(sj.toString());
        sc.close();
    }

    static boolean check(int n) {
        if (n % 7 == 0) return true;
        String str = String.valueOf(n);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '7') return true;
        }
        return false;
    }
}
