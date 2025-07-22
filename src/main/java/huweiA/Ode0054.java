package huweiA;

import java.util.*;

public class Ode0054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int[] res = count(s);
        if (res[1] < 0) {
            res[0] = -res[0];
            res[1] = -res[1];
        }
        int k = gcd(res[0], res[1]);
        res[0] = res[0] / k;
        res[1] = res[1] / k;
        if (res[1] == 0) {
            System.out.println("ERROR");
        } else if (res[1] == 1) {
            System.out.println(res[0]);
        } else {
            System.out.println(res[0] + "/" + res[1]);
        }
    }
    // 最大公约数
    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a < 0 ? -a : a;
    }

    private static int[] count (String s) {
        int n = s.length();
        Queue<int[]> nums = new LinkedList<>();
        Queue<Character> PorD = new LinkedList<>();
        int[] num = new int[2];
        num[0] = 0;
        num[1] = 1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            else if (c == '(') {
                int start = i;
                int count = 1;
                while (count != 0 || c != ')') {
                    i++;
                    c = s.charAt(i);
                    if (c == '(') {
                        count++;
                    }
                    if (c == ')') {
                        count--;
                    }
                }
                int[] cur = count(s.substring(start + 1, i));
                num[0] = cur[0];
                num[1] = cur[1];
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (num[1] == 0) {
                    return num;
                }
                int[] cur = new int[2];
                cur[0] = num[0];
                cur[1] = num[1];
                nums.offer(cur);
                PorD.offer(c);
                num[0] = 0;
                num[1] = 1;
            } else {
                int m = c - '0';
                num[0] = num[0] * 10 + m;
            }
        }
        if (num[1] == 0) {
            return num;
        }
        nums.offer(num);
        if (PorD.isEmpty()) {
            int[] arr = nums.poll();
            return arr;
        }
        int[] res = nums.poll();
        while (!PorD.isEmpty()) {
            char c = PorD.poll();
            int[] next = nums.poll();
            if (c == '+' || c == '-') {
                while (!PorD.isEmpty()) {
                    char nextC = PorD.peek();
                    if (nextC == '+' || nextC == '-') {
                        break;
                    } else {
                        PorD.poll();
                        int[] nextN = nums.poll();
                        if (nextC == '/') {
                            next[1] = next[1] * nextN[0];
                            next[0] = next[0] * nextN[1];
                        } else {
                            next[0] = next[0] * nextN[0];
                            next[1] = next[1] * nextN[1];
                        }
                    }
                }
                if (c == '+') {
                    res[0] = res[0] * next[1] + next[0] * res[1];
                    res[1] = res[1] * next[1];
                } else {
                    res[0] = res[0] * next[1] - next[0] * res[1];
                    res[1] = res[1] * next[1];
                }
            } else {
                if (c == '*') {
                    res[0] = res[0] * next[0];
                    res[1] = res[1] * next[1];
                } else {
                    res[1] = res[1] * next[0];
                    res[0] = res[0] * next[1];
                }
            }
        }
        return res;
    }
}
