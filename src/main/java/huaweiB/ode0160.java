package huaweiB;

import java.util.*;

public class ode0160 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int res = process(s);
        if (res == Integer.MIN_VALUE) {
            System.out.println("error");
        } else {
            System.out.println(res);
        }
    }

    private static int process(String s) {
        s = s.substring(1,s.length() - 1).trim();
        List<Integer> nums = new ArrayList<>();
        String opera;
        int index = 0;
        while (index < s.length() && s.charAt(index) != ' ') {
            index++;
        }
        opera = s.substring(0, index);
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == ' ') {
                index++;
            }
            else if (s.charAt(index) == '(') {
                int start = index;
                while (index < s.length() && s.charAt(index) != ')') {
                    index++;
                }
                int num = process(s.substring(start, ++index));
                nums.add(num);
            } else {
                int start = index;
                while (index < s.length() && s.charAt(index) != ' ') {
                    index++;
                }
                int num = Integer.parseInt(s.substring(start, index));
                nums.add(num);
            }
        }
        int num1 = nums.get(0);
        int num2 = nums.get(1);
        if (num1 == Integer.MIN_VALUE || num2 == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (opera.equals("div")) {
            if (num2 == 0) return Integer.MIN_VALUE;
            else {
                int res = num1 / num2;
                return res < 0 ? res - (num1%num2 == 0 ? 0 : 1) : res;
            }
        } else if (opera.equals("mul")) {
            return num1 * num2;
        } else if (opera.equals("add")) {
            return num1 + num2;
        } else {
            return num1 - num2;
        }
    }
}
