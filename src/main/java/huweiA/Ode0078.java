package huweiA;

import java.util.*;

public class Ode0078 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int left = n & (~n + 1);
        n += left;
        int newLeft = n & (~n + 1);
        int index = 1;
        while (newLeft != left << index ) {
            index++;
        }
        System.out.println(n + (1 << (index - 1)) - 1);
    }
}
