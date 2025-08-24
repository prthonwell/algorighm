package leetCode.from400to500;

import java.util.Stack;

public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < num.length(); i++) {
            int cur = num.charAt(i) - '0';
            while (!stack.isEmpty() && stack.peek() > cur && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(cur);
        }
        while (k-- > 0) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        while (!sb.isEmpty() && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.isEmpty() ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num = "152978509";
        RemoveKdigits removeKdigits = new RemoveKdigits();
        System.out.println(removeKdigits.removeKdigits(num, 6));
    }
}
