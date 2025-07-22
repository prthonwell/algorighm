package huweiA;

import java.util.*;

public class Ode0087 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int required = sc.nextInt();
        sc.nextLine();
        List<int[]> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (Objects.equals(line, "")) break;
            String[] split = line.split(" ");
            int[] arr = new int[2];
            try {
                arr[0] = Integer.parseInt(split[0]);
                arr[1] = Integer.parseInt(split[1]);
            } catch (NumberFormatException e) {
                System.out.println(-1);
                return;
            }
            list.add(arr);
        }
        list.sort( (a,b) -> a[0] - b[0] );
        List<int[]> freeSpace = new ArrayList<>();
        int preLimit = 0;
        for (int[] arr : list) {
            if (arr[0] > preLimit) {
                int[] cur = new int[2]; //  0 位置， 1长度
                cur[0] = preLimit;
                cur[1] = arr[0] - preLimit;
                if (cur[1] >= required) {
                    freeSpace.add(cur);
                }
            } else if (arr[0] < preLimit) {
                System.out.println(-1);
                return;
            }
            preLimit = arr[1] + arr[0];
        }
        if (preLimit >= 100) {
            System.out.println(-1);
            return;
        }
        if (100 - preLimit >= required) {
            freeSpace.add(new int[] { preLimit , 100 - preLimit });
        }
        if (freeSpace.isEmpty()) {
            System.out.println(-1);
            return;
        }
        int[] min = new int[] {0, Integer.MAX_VALUE};
        for (int[] arr : freeSpace) {
            if (arr[1] < min[1]) {
                min[1] = arr[1];
                min[0] = arr[0];
                if (min[1] == required) {
                    System.out.println(min[0]);
                    return;
                }
            }
        }
        System.out.println(min[0]);
    }
}
