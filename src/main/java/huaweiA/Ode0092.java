package huaweiA;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ode0092 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Pattern p = Pattern.compile("\\[\\d+,\\d+,\\d+]");
        Matcher m = p.matcher(s);
        List<int[]> list = new ArrayList<>();
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        while (m.find()) {
            String str = m.group();
            str = str.substring(1, str.length() - 1);
            String[] strs = str.split(",");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            int c = Integer.parseInt(strs[2]);
            l = Math.min(l, a);
            r = Math.max(r, b);
            list.add(new int[]{a,b,c});
        }
        int[] spec = new int[r - l + 1];
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (int[] a : list) {
            for (int i = a[0]; i <= a[1]; i++) {
                spec[i - l]++;
            }
        }
        int count = 0;
        for (int[] a : list) {
            for (int i = a[0]; i <= a[1]; i++) {
                if (spec[i - l] < 0) {
                    a[2]--;
                }
            }
            int right = a[1];
            while (a[2]-- > 0) {
                while (spec[right - l] < 0) {
                    right--;
                }
                spec[right - l] = -1;
                count++;
            }
        }
        System.out.println(count);
    }
}
