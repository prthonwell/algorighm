package from121to140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class WordBreak2 {
    public List<String> wordBreak2(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        char[] chars = s.toCharArray();
        int n = chars.length;
        List<String> res = new ArrayList<>();
        int len = 0;
        for (String word : wordDict) {
            len = Math.max(len, word.length());
        }
        List<String> sb = new ArrayList<>();
        dfs(0, s, n, res, len, set, sb);
        return res;
    }

    private void dfs(int i, String s, int n, List<String> res, int len, HashSet<String> set, List<String> sb) {
        for (int j = i + 1; j <= n && j <= i + len; j++) {
            String word = s.substring(i, j);
            if (set.contains(word)) {
                if (j == n) {
                    sb.add(word);
                    StringBuffer sb2 = new StringBuffer();
                    for (String str : sb) {
                        sb2.append(str);
                    }
                    res.add(sb2.toString());
                    sb.remove(sb.size() - 1);
                    return;
                }else {
                    sb.add(word);
                    sb.add(" ");
                    dfs(j, s, n, res, len, set, sb);
                    sb.remove(sb.size() - 1);
                    sb.remove(sb.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        WordBreak2 wb = new WordBreak2();
        String[] list = new String[] {"cat","cats","and","sand","dog"};
        List<String> dict = Arrays.stream(list).toList();
        wb.wordBreak2("catsanddog", dict);
    }
}