package huaweiA;

import java.util.*;

public class Ode0082 {
    static HashSet<Character> yuan = new HashSet<>();
    static {
        yuan.add('a');
        yuan.add('e');
        yuan.add('i');
        yuan.add('o');
        yuan.add('u');
        yuan.add('A');
        yuan.add('E');
        yuan.add('I');
        yuan.add('O');
        yuan.add('U');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        List<String> res = new ArrayList<>();
        for (String str : ss) {
            StringBuilder sb1 = new StringBuilder();
            int n = str.length();
            boolean reverse = true;
            for (int i = 0; i < n; i++) {
                if (yuan.contains(str.charAt(i))) {
                    sb1.append('*');
                    reverse = false;
                } else {
                    sb1.append(str.charAt(i));
                }
            }
            if (reverse && n > 1) {
                res.add(sb1.charAt(sb1.length() - 1) + sb1.substring(1, sb1.length() - 1) + sb1.charAt(0));
            } else {
                res.add(sb1.toString());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str : res) {
            sb.append(str).append(" ");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
