package huweiB;

import java.util.*;
import java.util.regex.Pattern;

public class ode0018 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            set.add(x * 100 + y);
            list.add(new int[] { x, y });
        }
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            int x1 = list.get(i)[0];
            int y1 = list.get(i)[1];
            for (int j = i + 1; j < list.size(); j++) {
                int xOffset = list.get(j)[0] - x1;
                int yOffset = list.get(j)[1] - y1;
                int x3 = x1 + yOffset ,
                        y3 = y1 - xOffset,
                        x4 = list.get(j)[0] + yOffset,
                        y4 = list.get(j)[1] - xOffset;
                if (set.contains(x3 * 100 + y3) && set.contains(x4 * 100 + y4)) {
                    res++;
                }
                x3 = x1 - yOffset;
                y3 = y1 + xOffset;
                x4 = list.get(j)[0] - yOffset;
                y4 = list.get(j)[1] + xOffset;
                if (set.contains(x3 * 100 + y3) && set.contains(x4 * 100 + y4)) {
                    res++;
                }
            }
        }
        System.out.println(res / 4);
    }

}
