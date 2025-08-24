package leetCode.from161to200;

import java.util.*;

public class FindRepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        int start = 0, end = start + 10;
        HashSet<String> res = new HashSet<>();
        while (end <= s.length()) {
            String cur = s.substring(start++, end++);
            if (set.contains(cur)) res.add(cur);
            else set.add(cur);
        }
        return res.stream().toList();
    }

    public static void main(String[] args) {
        FindRepeatedDnaSequences f = new FindRepeatedDnaSequences();
        f.findRepeatedDnaSequences("AAAAAAAAAAA");
    }
}
