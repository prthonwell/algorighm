package huweiB;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class odb0009 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine(), source = sc.nextLine();
        int index1 = target.length() - 1, index2 = source.length() - 1;
        while (index1 != -1 && index2 != -1) {
            if (source.charAt(index2) == target.charAt(index1)) {
                index1--;
            }
            index2--;
        }
        sc.close();
        if (index1 == -1) {
            System.out.println(index2 + 1);
        } else {
            System.out.println(-1);
        }
    }
}
