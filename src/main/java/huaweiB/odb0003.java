package huaweiB;

import java.util.*;

public class odb0003 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = chars[i] - '0';
        }
        sc.close();
        int[] rest = new int[10], save = new int[10];
        for (int i = 0; i < n; i++) {
            rest[arr[i]]++;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (save[arr[i]] == 2) continue;
            while (!stack.isEmpty()
                    && arr[i] > stack.peek()
                    && rest[stack.peek()] + save[stack.peek()] - 1 >= 2) {
                save[stack.pop()]--;
            }
            stack.push(arr[i]);
            save[arr[i]]++;
            rest[arr[i]]--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse());
    }
}
