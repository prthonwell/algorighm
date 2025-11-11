package huaweiB;

import java.util.*;

public class odb0050 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Deque<Character> stack = new ArrayDeque<>();
        int depth = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty()
                        || (c == '}' && stack.peek() != '{')
                        || (c == ')' && stack.peek() != '(')
                        || (c == ']' && stack.peek() != '[')) {
                    System.out.println(0);
                    return;
                }
                stack.poll();
                res = Math.max(res, depth);
                depth--;
            } else if (c == '{' || c == '[' || c == '(') {
                depth++;
                stack.push(c);
            } else {
                System.out.println(0);
                return;
            }
        }
        System.out.println(res);
    }

}
