package huaweiA;

import java.util.*;

public class Ode0099 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] coll = new int[4];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                coll[1]++;
            } else if (c >= '0' && c <= '9') {
                coll[2]++;
            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                coll[0]++;
            } else {
                coll[3]++;
            }
        }
        for (int j : coll) {
            System.out.println(j);
        }
    }
}
