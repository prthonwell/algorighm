package huweiB;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class odb0008 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), t = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if (k == 1) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] == t) {
                    count++;
                }
            }
            System.out.println(count);
            return;
        }
        Arrays.sort( arr );
        List<List<Integer>> res = new ArrayList<>();
        dfs(n ,t ,k, 0, 0, res, new ArrayList<>(), arr);
        sc.close();
        System.out.println(res.size());
    }

    private static void dfs(int n, int t, int k, int index, int sum, List<List<Integer>> res, ArrayList<Integer> path, int[] arr) {
        if (path.size() == k) {
            for (int i = index; i < n - 1; i++) {
                for (int j = n - 1; j > i; j--) {
                    if (arr[i] + arr[j] + sum == t) {
                        path.add(i);
                        path.add(j);
                        res.add(new ArrayList<>(path));
                        path.remove(path.size() - 1);
                        path.remove(path.size() - 1);
                    }
                    if (arr[i] + arr[j] +sum < t) break;
                }
            }
            return;
        }
        int rest = k - path.size();
        for (int i = index; i <= n - rest; i++) {
            if (sum + arr[i] * rest > t) break;
            path.add(i);
            dfs(n,t,k,i+1,sum+arr[i],res,path,arr);
            path.remove(path.size() - 1);
        }
    }
}
