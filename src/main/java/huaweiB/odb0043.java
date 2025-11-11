package huaweiB;

import java.util.*;

public class odb0043 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String DNA = sc.nextLine();
        int len = DNA.length();
        int n = sc.nextInt();
        sc.close();
        if (n == len) {
            System.out.println(DNA);
            return;
        }
        int startIndex = 0;
        int endIndex = n;
        int[] res = new int[] {startIndex, endIndex};
        int biggest = 0;
        for (int i = startIndex; i < endIndex; i++) {
            if (DNA.charAt(i) == 'C' || DNA.charAt(i) == 'G') {
                biggest++;
            }
        }
        int cur = biggest;
        while (endIndex < len) {
            cur += DNA.charAt(endIndex) == 'C' || DNA.charAt(endIndex) == 'G' ? 1 : 0;
            cur -= DNA.charAt(startIndex) == 'C' || DNA.charAt(startIndex) == 'G' ? 1 : 0;
            endIndex++;
            startIndex++;

            if (cur > biggest) {
                biggest = cur;
                res[0] = startIndex;
                res[1] = endIndex;
            }
        }
        System.out.println(DNA.subSequence(res[0], res[1]));

    }
}
