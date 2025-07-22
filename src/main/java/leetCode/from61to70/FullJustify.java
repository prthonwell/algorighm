package leetCode.from61to70;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        int[] lengths = new int[n];
        for (int i = 0; i < n; i++) {
            lengths[i] = words[i].length() + 1;
        }
        List<String> result = new ArrayList<>();
        int head = 0;
        int length = 0;
        int count = 0;
        while (head < n) {
            if (length + lengths[head] - 1 > maxWidth) {
                StringBuffer cur = new StringBuffer();
                if (count == 1) {
                    cur.append(words[head - 1]);
                    int rest = maxWidth - length + count;
                    char[] kong = new char[rest];
                    Arrays.fill(kong, ' ');
                    cur.append(kong);
                }else {
                    int start = head - count;
                    int rest = maxWidth - length + count;
                    int avg = rest / (count - 1);
                    rest = rest % (count - 1);
                    cur.append(words[start]);
                    for (int i = start + 1; i < head; i++) {
                        char[] chars;
                        if (rest-- > 0){
                            chars = new char[avg + 1];
                        } else {
                            chars = new char[avg];
                        }
                        Arrays.fill(chars, ' ');
                        cur.append(chars);
                        cur.append(words[i]);
                    }
                }
                result.add(cur.toString());
                length = 0;
                count = 0;
                continue;
            }
            length += lengths[head];
            head++;
            count++;
        }
        int start = head - count;
        int rest = maxWidth - length + 1;
        StringBuffer cur = new StringBuffer();
        cur.append(words[start]);
        for (int i = start + 1; i < head; i++) {
            cur.append(' ');
            cur.append(words[i]);
        }
        char[] kong = new char[rest];
        Arrays.fill(kong, ' ');
        cur.append(kong);
        result.add(cur.toString());
        return result;
    }
    public static void main(String[] args) {
        FullJustify fj = new FullJustify();
        fj.fullJustify(new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16);
    }
}