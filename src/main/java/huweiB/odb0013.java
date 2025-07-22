package huweiB;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class odb0013 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().toLowerCase();
        String cs = sc.nextLine();
        char c = cs.toLowerCase().charAt(0);
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == c) {
                count++;
            }
        }
        sc.close();
        System.out.println(count);
    }
}
