package huaweiA;

import java.util.*;

public class Ode0035 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int sdt = sc.nextInt();
        sc.close();
        String[] arr = s.split(",");
        int n = arr.length;
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt( arr[i] );
        }
        ArrayList<Integer> highPos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (( i == 0 || arr1[i] > arr1[i - 1]) && (i == n - 1 || arr1[i] > arr1[i + 1])) {
                highPos.add(i);
            }
        }
        int[] up = new int[n];
        int[] down = new int[n];
        Arrays.fill( up, Integer.MAX_VALUE / 2 );
        Arrays.fill( down, Integer.MAX_VALUE / 2 );
        int from = -1;
        for (int i = 0; i < n; i++) {
            if (arr1[i] == 0) {
                up[i] = 0;
                down[i] = 0;
                from = i;
                continue;
            }
            if (from == -1) continue;
            int dis = arr1[i - 1] - arr1[i];
            if (dis < 0) {
                up[i] = up[i - 1] + -dis * 2;
                down[i] = down[i - 1] + -dis;
            } else {
                up[i] = up[i - 1] + dis;
                down[i] = down[i - 1] + dis * 2;
            }
        }
        from = n;
        for (int index = n - 1; index >= 0; index--) {
            if (arr1[index] == 0) {
                from = index;
                continue;
            }
            if (from == n) continue;
            int dis = arr1[index + 1] - arr1[index];
            if (dis < 0) {
                up[index] = Math.min(up[index], up[index + 1] + -dis * 2);
                down[index] = Math.min(down[index], down[index + 1] + -dis);
            } else {
                up[index] = Math.min(up[index], up[index + 1] + dis);
                down[index] = Math.min(down[index], down[index + 1] + dis * 2);
            }
        }
        int count = 0;
        for (int high : highPos) {
            if (up[high] + down[high] < sdt) {
                count++;
            }
        }

        System.out.println(count);
    }
}