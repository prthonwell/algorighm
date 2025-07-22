package huweiA;

import java.util.*;

public class Ode0093 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();
        sc.close();
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = s.charAt(i);
        }
        List<Character> list = Arrays.stream(chars).sorted().toList();
        Character find = list.get(n - 1);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == find) {
                System.out.println(i);
                return;
            }
        }
    }
}
