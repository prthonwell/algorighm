package leetCode.from121to140;

import java.util.*;

class FindLadders {
    // https://leetcode.cn/problems/word-ladder-ii/ 126
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return result;
        }
        dict.remove(beginWord);
        HashMap<String, List<String>> fathersMap = new HashMap<>();
        HashMap<String, Integer> steps = new HashMap<>();
        int n = wordList.size();
        int len = endWord.length();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 1;
        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] chars = word.toCharArray();
                for (int j = 0; j < len; j++) {
                    char o = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String newWord = new String(chars);
                        if (fathersMap.containsKey(newWord)) {
                            if (steps.get(newWord) == step) {
                                fathersMap.get(newWord).add(word);
                            }
                        }
                        if (!dict.contains(newWord)) {
                            continue;
                        }
                        dict.remove(newWord);
                        steps.put(newWord, step);
                        queue.offer(newWord);
                        fathersMap.putIfAbsent(newWord, new ArrayList<>());
                        fathersMap.get(newWord).add(word);
                        if (newWord.equals(endWord)) {
                            found = true;
                        }
                    }
                    chars[j] = o;
                }
            }
            step++;
            if (found) {
                break;
            }
        }

        if (found) {
            dfs(result, fathersMap, endWord, beginWord, new ArrayDeque<String>());
        }
        return result;
    }

    private void dfs(List<List<String>> result, HashMap<String, List<String>> fathersMap, String cur, String beginWord, Deque<String> path) {
        if (cur.equals(beginWord)) {
            path.addFirst(beginWord);
            result.add(new ArrayList<>(path));
            path.removeFirst();
            return;
        }
        path.addFirst(cur);
        for (String word : fathersMap.get(cur)) {
            dfs(result, fathersMap, word, beginWord, path);
        }
        path.removeFirst();
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "lot";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        FindLadders findLadders = new FindLadders();
        List<List<String>> ladders = findLadders.findLadders(beginWord, endWord, wordList);
        for (List<String> l : ladders) {
            System.out.println(l);
        }
    }

    public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        // 因为需要快速判断扩展出的单词是否在 wordList 里，因此需要将 wordList 存入哈希表，这里命名为「字典」
        Set<String> dict = new HashSet<>(wordList);
        // 特殊用例判断
        if (!dict.contains(endWord)) {
            return res;
        }

        dict.remove(beginWord);

        // 第 1 步：广度优先搜索建图
        // 记录扩展出的单词是在第几次扩展的时候得到的，key：单词，value：在广度优先搜索的第几层
        Map<String, Integer> steps = new HashMap<String, Integer>();
        steps.put(beginWord, 0);
        // 记录了单词是从哪些单词扩展而来，key：单词，value：单词列表，这些单词可以变换到 key ，它们是一对多关系
        Map<String, List<String>> from = new HashMap<String, List<String>>();
        int step = 1;
        boolean found = false;
        int wordLen = beginWord.length();
        Queue<String> queue = new ArrayDeque<String>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                char[] charArray = currWord.toCharArray();
                // 将每一位替换成 26 个小写英文字母
                for (int j = 0; j < wordLen; j++) {
                    char origin = charArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[j] = c;
                        String nextWord = String.valueOf(charArray);
                        if (steps.containsKey(nextWord) && step == steps.get(nextWord)) {
                            from.get(nextWord).add(currWord);
                        }
                        if (!dict.contains(nextWord)) {
                            continue;
                        }
                        // 如果从一个单词扩展出来的单词以前遍历过，距离一定更远，为了避免搜索到已经遍历到，且距离更远的单词，需要将它从 dict 中删除
                        dict.remove(nextWord);
                        // 这一层扩展出的单词进入队列
                        queue.offer(nextWord);

                        // 记录 nextWord 从 currWord 而来
                        from.putIfAbsent(nextWord, new ArrayList<>());
                        from.get(nextWord).add(currWord);
                        // 记录 nextWord 的 step
                        steps.put(nextWord, step);
                        if (nextWord.equals(endWord)) {
                            found = true;
                        }
                    }
                    charArray[j] = origin;
                }
            }
            step++;
            if (found) {
                break;
            }
        }

        // 第 2 步：回溯找到所有解，从 endWord 恢复到 beginWord ，所以每次尝试操作 path 列表的头部
        if (found) {
            Deque<String> path = new ArrayDeque<>();
            path.add(endWord);
            backtrack(from, path, beginWord, endWord, res);
        }
        return res;
    }

    public void backtrack(Map<String, List<String>> from, Deque<String> path, String beginWord, String cur, List<List<String>> res) {
        if (cur.equals(beginWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (String precursor : from.get(cur)) {
            path.addFirst(precursor);
            backtrack(from, path, beginWord, precursor, res);
            path.removeFirst();
        }
    }
}