package huweiB;

import java.util.*;

public class ode0044 {

    static class preTree {
        preTree[] next;
        boolean IsEnd;

        preTree () {
            next = new preTree[128];
            IsEnd = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split(" ");
        String s2 = sc.nextLine();
        preTree tree = new preTree();
        for (String string : s1) {
            int n = string.length();
            preTree curTree = tree;
            for (int j = 0; j < n; j++) {
                char c = string.charAt(j);
                if ((c > 'Z' && c < 'a') || c > 'z' || c < 'A') continue;
                int index = string.charAt(j) - 'A';
                if (curTree.next[index] == null) {
                    curTree.next[index] = new preTree();
                }
                curTree = curTree.next[index];
                if (j == n - 1) {
                    curTree.IsEnd = true;
                }
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            int index = s2.charAt(i) - 'A';
            if (tree.next[index] == null) {
                System.out.println(s2);
                return;
            }
            tree = tree.next[index];
        }
        StringBuilder sb = new StringBuilder(s2);
        List<String> res = new ArrayList<>();
        dfs(sb, res, tree);
        for (String s : res) {
            System.out.print(s + " ");
        }
        sc.close();
    }

    private static void dfs(StringBuilder sb, List<String> res, preTree tree) {
        if (tree.IsEnd) {
            res.add(sb.toString());
        }
        for (int i = 0; i < 128; i++) {
            if (tree.next[i] != null) {
                char c = (char) ('A' + i);
                sb.append(c);
                dfs(sb, res, tree.next[i]);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
