package huweiA;

import java.util.*;

public class Ode0104 {
    static int sum = 0;
    static int floor = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        floor = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        sc.close();
        Arrays.sort(arr);
        int minus = m / 2;
        List<List<Integer>> res = new ArrayList<>();
        backTra(minus, 0, arr, new ArrayList<>(),0, res);
        res.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(minus) - o1.get(minus) ;
            }
        });
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(res.get(0));
        int max = res.get(0).get(minus), index = 1;
        while (res.get(index).get(minus) == max) {
            ans.add(res.get(index));
            index++;
        }
        res.clear();
        for (List<Integer> a : ans) {
            a.remove(minus);
            res.add(getRes(a, arr));
        }
        res.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                for (int i = 0; i < o1.size(); i++) {
                    if (o1.get(i) > o2.get(i)) return -1;
                    else if (o1.get(i) < o2.get(i)) return 1;
                }
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Integer i : res.get(0)) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }

    private static List<Integer> getRes(List<Integer> a, int[] arr) {
        boolean[] minus = new boolean[arr.length];
        for (Integer i : a) {
            minus[i] = true;
        }
        int i1 = arr.length - 1, i2 = arr.length - 1;
        List<Integer> res = new ArrayList<>();
        while (i1 >= 0 && i2 >= 0) {
            if (minus[i1]) {
                i1--;
                continue;
            }
            if (!minus[i2]) {
                i2--;
                continue;
            }
            res.add(arr[i1]);
            res.add(arr[i2]);
            i1--;
            i2--;
        }
        if (arr.length % 2 == 1) {
            while (minus[i1]) {
                i1--;
            }
            res.add(arr[i1]);
        }
        return res;
    }

    private static void backTra(int len, int i, int[] arr, ArrayList<Integer> path, int MinusSum, List<List<Integer>> res) {
        if (0 == len) {
            int n = sum - 2 * MinusSum;
            if (n <= floor) {
                path.add(n);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        for (int j = i; j <= arr.length - len; j++) {
            if (j != i && arr[j] == arr[j - 1]) continue;
            path.add(j);
            backTra(len - 1, j + 1, arr, path, MinusSum + arr[j], res);
            path.remove(path.size() - 1);
        }
    }
}
