package leetCode.from41to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class GroupAnagrams {
    // https://leetcode.cn/problems/group-anagrams/
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> ans = new HashMap<>();
        for (String str : strs) {
            char[] wordChars = str.toCharArray();
            Arrays.sort(wordChars);
            String word = String.valueOf(wordChars);
            if (!ans.containsKey(word)) ans.put(word, new ArrayList<>());
            ans.get(word).add(str);
        }
        return new ArrayList<>(ans.values());
    }
}