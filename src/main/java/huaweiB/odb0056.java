package huaweiB;

import java.util.*;

public class odb0056 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(",")).mapToInt( Integer::parseInt ).toArray();
        int max = sc.nextInt();
        Arrays.sort(nums);
        int index = 0, n = nums.length, weight = 0;
        while (index < n) {
            weight += nums[index];
            if (weight > max) {
                System.out.println(index);
                return;
            }
            index++;
        }
        System.out.println(n);
        sc.close();
    }
}
