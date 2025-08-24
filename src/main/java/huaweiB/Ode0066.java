package huaweiB;

import java.util.*;

public class Ode0066 {

    static class WordTree {
        String word;
        WordTree Have;
        WordTree DontHave;
        public WordTree() {}
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] Words = sc.nextLine().split(",");
        String[] stores = sc.nextLine().split(",");
        WordTree tree = new WordTree();
        for ( int i = 0; i < stores.length; i++ ) {
            boolean[] spec = new boolean[26];
            for ( int j = 0; j < stores[i].length(); j++ ) {
                spec[stores[i].charAt(j) - 'a'] = true;
            }
            WordTree cur = tree;
            for ( int j = 0; j < 26; j++ ) {
                if (spec[j]) {
                    if (cur.Have == null) cur.Have = new WordTree();
                    cur = cur.Have;
                } else {
                    if (cur.DontHave == null) cur.DontHave = new WordTree();
                    cur = cur.DontHave;
                }
            }
            cur.word = stores[i];
        }
        StringJoiner sj = new StringJoiner(",");
        out: for ( int i = 0; i < Words.length; i++ ) {
            boolean[] spec = new boolean[26];
            for ( int j = 0; j < Words[i].length(); j++ ) {
                spec[Words[i].charAt(j) - 'a'] = true;
            }
            WordTree cur = tree;
            for ( int j = 0; j < 26; j++ ) {
                if (spec[j]) {
                    if (cur.Have == null) continue out;
                    cur = cur.Have;
                } else {
                    if (cur.DontHave == null) continue out;
                    cur = cur.DontHave;
                }
            }
            sj.add(cur.word);
        }
        if (sj.length() == 0) System.out.println("not found");
        else System.out.println(sj.toString());
    }
}
