package huweiB;

import java.util.*;
import java.util.regex.Pattern;

public class ode0024 {

    static class ThirdTree {
        int v;
        int level;
        ThirdTree left;
        ThirdTree mid;
        ThirdTree right;
        ThirdTree (int v) {
            this.v = v;
        }

        int insert (int x, int level) {
            if (x < v - 500) {
                if (left == null) {
                    ThirdTree t = new ThirdTree(x);
                    t.level = level + 1;
                    this.left = t;
                    return level + 1;
                } else return this.left.insert(x, level + 1);
            } else if (x > v + 500) {
                if (right == null) {
                    ThirdTree t = new ThirdTree(x);
                    t.level = level + 1;
                    this.right = t;
                    return level + 1;
                } else return this.right.insert(x, level + 1);
            } else {
                if (mid == null) {
                    ThirdTree t = new ThirdTree(x);
                    t.level = level + 1;
                    this.mid = t;
                    return level + 1;
                } else return this.mid.insert(x, level + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int level = 1;
        ThirdTree root = new ThirdTree(a[0]);
        for (int i = 1; i < n; i++) {
            level = Math.max(level, root.insert(a[i], 1));
        }
        System.out.println(level);
        sc.close();
    }
}
