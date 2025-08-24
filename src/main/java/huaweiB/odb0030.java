package huaweiB;

import java.util.*;

public class odb0030 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String[] str = sc.nextLine().split(" ");
        for (String s : str) {
            list.add(Integer.parseInt(s));
        }
        int[] arr = new int[13];
        for (Integer i : list) {
            arr[i - 1]++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        List<int[]> res = new ArrayList<>();
        for (int i = 12; i >= 0; i--) {
            if (arr[i] >= 4) {
                res.add(new int[] { i + 1, arr[i]});
                arr[i] = 0;
            }
        }
        res.sort( (a, b) -> b[1] * b[0] - a[1] * a[0]);
        for (int[] a : res) {
            for (int i = 0; i < a[1]; i++) {
                stringBuilder.append(a[0]).append(" ");
            }
        }
        for (int i = 12; i >= 0; i--) {
            if (arr[i] == 3) {
                int part = findTwo(i, arr);
                if (part != -1) {
                    arr[part] -= 2;
                    arr[i] -= 3;
                    stringBuilder.append((i + 1)).append(" ").append(i + 1).append(" ").append(i + 1).append(" ").append(part + 1).append(" ").append(part + 1).append(" ");
                } else {
                    arr[i] -= 3;
                    stringBuilder.append((i + 1)).append(" ").append(i + 1).append(" ").append(i + 1);
                }
            }
        }
        for (int i = 12; i >= 0; i--) {
            if (arr[i] == 2) {
                arr[i] -= 2;
                stringBuilder.append((i + 1)).append(" ").append(i + 1).append(" ");
            }
        }
        for (int i = 12; i >= 0; i--) {
            if (arr[i] != 0) {
                stringBuilder.append((i + 1)).append(" ");
            }
        }
        sc.close();
        System.out.println(stringBuilder);
    }

    private static int findTwo(int maxPos, int[] arr) {
        for (int i = 12; i >= 0; i--) {
            if (i == maxPos) continue;
            if (arr[i] >= 2) {
                return i;
            }
        }
        return -1;
    }
}
