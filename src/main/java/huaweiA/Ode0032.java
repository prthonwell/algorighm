package huaweiA;

import java.util.*;

public class Ode0032 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int[] timeLimit = new int[2];
        for ( int i = 0; i < 2; i++ ) {
            int hour = sc.nextInt();
            int minute = sc.nextInt();
            timeLimit[i] = hour * 60 + minute;
        }
        if (timeLimit[1] < 480) {
            sc.close();
            return;
        }
        if (timeLimit[0] < 480) {
            timeLimit[0] = 480;
        }
        int n = sc.nextInt();
        int[][] testPoints = new int[n][3];
        for ( int i = 0; i < n; i++ ) {
            int id = sc.nextInt();
            int distance = sc.nextInt();
            int pp = sc.nextInt();
            testPoints[ i ] = new int[] { id, distance, pp };
        }
        sc.close();
        ArrayList<int[]> res = new ArrayList<>();
        for ( int i = 0; i < n; i++ ) {
            int[] cur = testPoints[ i ];
            int onWayT = cur[1] * 10;
            if (timeLimit[0] + onWayT > timeLimit[1]) {
                continue;
            }
            int pp =  cur[2];
            int index = 1;
            int count = 0;
            while (index < onWayT) {
                int curTime = timeLimit[0] + index;
                if (curTime >= 480 && curTime < 600) {
                    count = 0;
                    pp = pp + 2;
                } else if (curTime >= 720 && curTime < 840) {
                    count = 0;
                    pp = pp + 9;
                } else if (curTime >= 1080 && curTime < 1200) {
                    count = 0;
                    pp = pp + 19;
                } else {
                    if (count == 4) {
                        count = -1;
                    } else {
                        pp = Math.max(0, pp - 1);
                    }
                    count++;
                }
                index++;
            }
            int endTime = onWayT + pp + timeLimit[0];
            if (endTime > timeLimit[1] ) {
                continue;
            }
            res.add( new int[] { cur[0], onWayT + pp, onWayT} );
        }
        res.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1] ? o1[1] - o2[1]
                        : o1[2] != o2[2] ? o1[2] - o2[2]
                        : o1[0] - o2[0];
            }
        });
        System.out.println(res.size());
        for (int[] arr : res) {
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
        }
    }
}