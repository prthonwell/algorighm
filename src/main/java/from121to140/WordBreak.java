package from121to140;

import java.util.*;
import java.util.stream.Collectors;

class WordBreak {
    public class TreeNode {
        boolean isEnd = false;
        TreeNode[] children;
        public TreeNode () {
            children = new TreeNode[26];
        }

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = 0;
        HashSet<String> set = new HashSet<>(wordDict);
        for (String word : wordDict) {
            len = Math.max(len, word.length());
        }
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            int start = i - len - 1;
            for (int j = Math.max(start,0); j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        String[] ss = new String[] {"cats","dog","sand","and","cat"};
        List<String> wordDict = Arrays.asList(ss);
        System.out.println(wb.wordBreak("catsandog", wordDict));
    }
}