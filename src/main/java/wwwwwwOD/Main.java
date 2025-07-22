package wwwwwwOD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {

    static List<String[]> data = new ArrayList<>();
    static  {
        data.add(new String[] {"10", "11", "0f", "13", "14", "15", "16", "0f", "18", "19"});
        data.add(new String[] {"11", "13", "0f", "17", "19", "21", "23", "0f", "27", "29"});
        data.add(new String[] {"12", "14", "0f", "18", "20", "22", "24", "0f", "28", "30"});
    }

    private static int getNum (String s) {
        int num = 0;
        char c1 = s.charAt(0);
        char c2 = s.charAt(1);
        if (c1 == 'a') num += 10 * 16;
        else if (c1 == 'b') num += 11 * 16;
        else if (c1 == 'c') num += 12 * 16;
        else if (c1 == 'd') num += 13 * 16;
        else if (c1 == 'e') num += 14 * 16;
        else if (c1 == 'f') num += 15 * 16;
        else num += (c1 - '0') * 16;
        if (c2 == 'a') num += 10;
        else if (c2 == 'b') num += 11;
        else if (c2 == 'c') num += 12;
        else if (c2 == 'd') num += 13;
        else if (c2 == 'e') num += 14;
        else if (c2 == 'f') num += 15;
        else num += (c2 - '0');
        return num;
    }

    private static String getS (int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            int cur = num % 16;
            if (cur < 10) sb.append(cur);
            else if (cur == 10) sb.append("a");
            else if (cur == 11) sb.append("b");
            else if (cur == 12) sb.append("c");
            else if (cur == 13) sb.append("d");
            else if (cur == 14) sb.append("e");
            else sb.append("f");
            num /= 16;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        List<Integer> groups = new ArrayList<>();
        in.close();
        int group = Integer.parseInt(s[2]);
        if (group > 3 || group < 0) {
            System.out.println("c1 01");
            return;
        }
        int index = 3;
        while (index < group + 3) {
            int num = getNum(s[index]);
            if (num > 3 || num < 0) {
                System.out.println("c1 01");
                return;
            }
            groups.add(num);
            index++;
        }
        int part = getNum(s[index++]);
        int cur = index;
        List<int[]> parts = new ArrayList<>();
        while (index < cur + 2 * part) {
            int start = getNum(s[index]);
            int len = getNum(s[index+1]);
            if (start < 0 || start + len > 10) {
                System.out.println("c1 02");
                return;
            }
            index += 2;
            parts.add(new int[]{start, len});
        }
        int key = getNum(s[index]);
        StringBuilder stringBuilder = new StringBuilder();
        int len = 1;
        for (Integer g : groups) {
            String[] d = data.get(g);
            stringBuilder.append(getS(g)).append(" ");
            stringBuilder.append(getS(part)).append(" ");
            len += 2;
            for (int[] p : parts) {
                stringBuilder.append(getS(p[0])).append(" ");
                stringBuilder.append(getS(p[1])).append(" ");
                len += 2;
                for (int i = p[0]; i < p[0] + p[1]; i++) {
                    int num = getNum(d[i]);
                    if (num > key) {
                        stringBuilder.append(getS(num)).append(" ");
                        len++;
                    }
                }
            }
        }
        stringBuilder.insert(0, getS(group) + " ");
        stringBuilder.insert(0, getS(len) + " ");
        System.out.println("f5 " + stringBuilder.toString());
    }
}