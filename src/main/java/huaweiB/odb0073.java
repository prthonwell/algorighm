package huaweiB;

import java.util.*;

public class odb0073 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cityX = sc.nextInt(), cityY = sc.nextInt(), XNeed = sc.nextInt(), YNeed = sc.nextInt();
        int l = 0, r = (XNeed + YNeed) * 2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(mid, cityX, cityY, XNeed, YNeed)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }

    private static boolean check(int v, int cityX, int cityY, int xNeed, int yNeed) {
        int c1 = v / cityX, c2 = v / cityY, c3 = v / (cityX * cityY) ;
        return v - (c1 + c2 - c3) >= Math.max(0, xNeed - c2 + c3) + Math.max(0, yNeed - c1 + c3);
    }
}
