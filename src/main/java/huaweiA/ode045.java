package huaweiA;

import java.util.*;

public class ode045 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] arr = new int[3]; // 0 ID  1 第一天  2 打卡次数
            arr[0] = i;
            list.add(arr);
        }
        List<Integer> PerDayNums = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            PerDayNums.add(sc.nextInt());
        }
        for (int i = 0; i < 30; i++) {
            int num = PerDayNums.get(i);
            while (num-- > 0) {
                int ID = sc.nextInt();
                if (ID >= 0 && ID < n) {
                    int[] cur = list.get(ID);
                    if (cur[2] == 0) cur[1] = i;
                    cur[2]++;
                }
            }
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] != o1[2] ? o2[2] - o1[2] :
                        o1[1] != o2[1] ? o1[1] - o2[1] :
                        o1[0] - o2[0];
            }
        });
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < Math.min(5, n); i++) {
            sj.add(list.get(i)[0] + "");
        }
        System.out.println(sj.toString());
    }
}
