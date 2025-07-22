package huweiB;

import java.util.*;

public class odb0055 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        List<Integer> result = new ArrayList<>();
        for ( int i = 0; i < N; i++) {
            int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt( Integer::parseInt ).toArray();
            int index = 1, n = nums.length;
            int l = 64, r = -1, t = 64, b = 0;
            while (index < n) {
                int x = nums[index];
                int y = nums[index + 1];
                index += 2;
                l = Math.min(y, l);
                r = Math.max(y, r);
                t = Math.min(x, t);
                b = Math.max(x, b);
            }
            result.add((r - l + 1) * 2 + (b - t + 1) * 2);
        }
        StringJoiner sj = new StringJoiner(" ");
        for (Integer i : result) {
            sj.add(i.toString());
        }
        System.out.println(sj.toString());
        sc.close();
    }
}
