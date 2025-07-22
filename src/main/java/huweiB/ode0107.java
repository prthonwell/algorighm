package huweiB;

import java.util.*;

public class ode0107 {

    static class TreeNode {
        TreeNode[] children;
        boolean isEnd;
        TreeNode( ) {
            children = new TreeNode[128];
            isEnd = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] ss = sc.nextLine().split(",");
        TreeNode root = new TreeNode();
        for (String s : ss) {
            TreeNode cur = root;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i);
                if (cur.children[index] == null) {
                    cur.children[index] = new TreeNode();
                    cur = cur.children[index];
                } else {
                    cur = cur.children[index];
                }
                if (i == s.length() - 1) {
                    cur.isEnd = true;
                }
            }
        }
        List<String> res = new ArrayList<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            TreeNode cur = root;
            if (cur.children[c] == null) {
                res.add(String.valueOf(c));
            } else {
                String temp = String.valueOf(c);
                int tempIndex = i;
                StringBuilder sb = new StringBuilder();
                while (i < n && cur.children[str.charAt(i)] != null) {
                    c = str.charAt(i);
                    sb.append(c);
                    cur = cur.children[c];
                    if (cur.isEnd) {
                        tempIndex = i;
                        temp = sb.toString();
                    }
                    i++;
                }
                i = tempIndex;
                res.add(temp);
            }
        }
        System.out.println(String.join(",", res));
        sc.close();
    }
}
