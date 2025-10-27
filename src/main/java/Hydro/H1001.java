package Hydro;

import java.util.HashSet;
import java.util.Scanner;

public class H1001 {
    static class DicTree {
        DicTree[] nexts;
        boolean isEnd;

        DicTree() {
            nexts = new DicTree[26];
            isEnd = false;
        }

        boolean addAndIsNew(String word) {
            DicTree cur = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (cur.nexts[index] == null) {
                    cur.nexts[index] = new DicTree();
                    cur = cur.nexts[index];
                } else {
                    cur = cur.nexts[index];
                }
            }
            if (!cur.isEnd) {
                cur.isEnd = true;
                return true;
            } else {
                return false;
            }
        }

        boolean contains(String word) {
            DicTree cur = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (cur.nexts[index] == null) {
                    return false;
                } else {
                    cur = cur.nexts[index];
                }
            }
            return cur.isEnd;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String cur = sc.nextLine();
            set.add(cur);
        }
        System.out.println(set.size());
    }
}
