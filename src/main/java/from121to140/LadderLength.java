package from121to140;

import java.util.*;

class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        dict.remove(beginWord);
        HashSet<String> res = new HashSet<>();
        char[] chars = beginWord.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char o = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String newWord = new String(chars);
                if (dict.contains(newWord)) {
                    if (newWord.equals(endWord)) {return 2;}
                    res.add(newWord);
                }
            }
            chars[i] = o;
        }
        dict.remove(endWord);
        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(endWord);
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char ch = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String newWord = new String(chars);
                        if (!dict.contains(newWord)) continue;
                        dict.remove(newWord);
                        queue.add(newWord);
                        if (res.contains(newWord)) {
                            return step + 2;
                        }
                    }
                    chars[j] = ch;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        LadderLength findLadders = new LadderLength();
        int l = findLadders.ladderLength(beginWord, endWord, wordList);
        System.out.println(l);

    }
}