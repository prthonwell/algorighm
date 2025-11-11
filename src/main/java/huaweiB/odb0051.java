package huaweiB;

import java.util.*;

public class odb0051 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Deque<Character> stack = new ArrayDeque<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(-1);
                    return;
                }
                stack.poll();
                num++;
            } else if (c == '(') {
                stack.push(c);
            }
        }
        if (stack.isEmpty()) System.out.println(num);
        else System.out.println(-1);
    }

}
