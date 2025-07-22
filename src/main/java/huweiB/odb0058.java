package huweiB;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class odb0058 {
    static HashMap<String, String> TtoN = new HashMap<>();
    static HashMap<String, String> NtoT = new HashMap<>();
    static {
        TtoN.put( "String", "1" );
        TtoN.put( "Integer", "0");
        TtoN.put( "Compose", "2");
        NtoT.put( "1", "String" );
        NtoT.put( "0", "Integer" );
        NtoT.put( "2", "Compose" );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mod = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        if (mod == 1) {
            System.out.println(coding(s));
        } else {
            System.out.println(decoding(s));
        }
        sc.close();
    }

    private static String decoding(String s) {
        if (s.charAt(0) < '0' || s.charAt(0) > '9') return "DECODE_ERROR";
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int count = 0;
        StringBuilder cur = new StringBuilder();
        String[] con = new String[4];
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == '#') {
                con[count++] = cur.toString();
                if (count == 3) {
                    int len = Integer.parseInt(con[2]);
                    String substring = s.substring(index + 1, index + len + 1);
                    if (con[1].equals("2"))
                        con[3] = decoding(substring);
                    else con[3] = substring;
                    sb.append('[').append(con[0]).append(',');
                    sb.append(NtoT.get(con[1])).append(',');
                    sb.append(con[3]).append(']').append(',');
                    con = new String[4];
                    count = 0;
                    index += len;
                }
                cur = new StringBuilder();
            } else {
                cur.append(c);
            }
            index++;
        }
        return !sb.isEmpty() ? sb.substring(0, sb.length() - 1) : "";
    }

    private static String coding(String s) {
        int n = s.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '[') {
                int index = i + 1, count = 1;
                while (index < n && count != 0) {
                    char c1 = s.charAt(index);
                    if (c1 == '[') count++;
                    else if (c1 == ']') count--;
                    index++;
                }
                list.add(s.substring(i, index));
                i = index;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String m : list) {
            String group = m.substring(1, m.length() - 1);
            int len = group.length(), count = 0;
            String[] con = new String[3];
            StringBuffer cur = new StringBuffer();
            for (int i = 0; i < len; i++) {
                char c = group.charAt(i);
                if (c == ',') {
                    con[count++] = cur.toString();
                    cur = new StringBuffer();
                    if (count == 2 ) {
                        if (Objects.equals(con[1], "Compose"))
                            con[2] = coding(group.substring(i + 1));
                        else con[2] = group.substring(i + 1);
                        break;
                    }
                } else {
                    cur.append(c);
                }
            }
            if (!TtoN.containsKey(con[1])) continue;
            sb.append(con[0]).append("#");
            sb.append(TtoN.get(con[1])).append("#");
            sb.append((con[2].length())).append("#");
            sb.append(con[2]);
        }
        String check = decoding(sb.toString());
        return check.equals(s) ? sb.toString() : "ENCODE_ERROR";
    }
}
