package huweiB;

import java.util.*;

public class odb0032 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<Integer> list = new ArrayList<>();
        int count = 0, i = 0, sum = 0;
        while (s.charAt(i) == '0') {
            i++;
        }
        sum += i / 2;
        for (; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                count++;
            } else{
                if (count != 0) {
                    list.add(count);
                    count = 0;
                }
            }
        }
        sum += count / 2;
        for (Integer j : list) {
            sum += (j - 1) / 2;
        }
        sc.close();
        System.out.println(sum);
    }
}
