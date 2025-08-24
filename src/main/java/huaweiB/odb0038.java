package huaweiB;

import java.util.*;

public class odb0038 {

    static class Node {
        String val;
        HashSet<Node> nexts;
        boolean isEnd;

        Node (String v) {
            val = v;
            nexts = new HashSet<>();
            isEnd = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Node> start = new HashMap<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) break;
            String[] words = line.split( " " );
            Node cur = new Node ( words[0] );
            int index = 0;
            if (start.containsKey(words[0])) {
                cur = start.get(words[0]);
                while (index + 1 < words.length) {
                    boolean found = false;
                    for (Node n : cur.nexts) {
                        if (Objects.equals(n.val, words[index + 1])) {
                            index++;
                            cur = n;
                            found = true;
                        }
                    }
                    if (!found) {
                        break;
                    }
                }
            } else {
                start.put( cur.val, cur );
            }
            while (index + 1 < words.length) {
                Node next = new Node( words[index + 1] );
                cur.nexts.add( next );
                index++;
                cur = next;
            }
            cur.isEnd = true;
        }
        String[] str = sc.nextLine().split( " " );
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            if (!start.containsKey(s)) sb.append('(').append( s ).append( ')' );
            else {
                StringBuilder cur = new StringBuilder();
                cur.append(s);
                Node curNode = start.get(s);
                String tempStr = cur.toString();
                int tempIndex = i;
                while (i + 1 < str.length) {
                    boolean found = false;
                    for (Node curN : curNode.nexts) {
                        if (curN.val.equals(str[i + 1])) {
                            found = true;
                            cur.append(' ').append( str[i + 1] );
                            i++;
                            curNode = curN;
                            if (curNode.isEnd) {
                                tempStr = cur.toString();
                                tempIndex = i;
                            }
                            break;
                        }
                    }
                    if (!found) {
                        break;
                    }
                }
                i = tempIndex;
                sb.append('(').append(tempStr).append( ')' );
            }
        }
        System.out.println(sb);
        sc.close();
    }
}
