package mei;

import java.util.Scanner;
import java.util.TreeMap;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int times = in.nextInt();
            String[] res = new String[times];
            while (times-- > 0) {
                int a = in.nextInt();
                String str = in.next();
                char[] charArray = str.toCharArray();
                int[] arr = new int[a + 1];
                for (int i = 0; i < a; i++) {
                    arr[i + 1] = charArray[i] - '0';
                }
                int first = 0;
                int index = 1;
                boolean haveEqual = false;
                for (; index <= a; index++) {
                    if (arr[index] == first) {
                        haveEqual = true;
                    }
                    if (arr[index] < first) {
                        break;
                    }
                    first = arr[index];
                }
                if (index == a || arr[index] > first) {
                    if (haveEqual) {
                        res[times] = "YES";
                    } else {
                        res[times] = "NO";
                    }
                }
                first = arr[index - 1];
                int firstPos = index - 1;
                // 倒着找到第一个不是升序的地方
                int last = a;
                int tail = arr[a];
                while (arr[a - 1] < tail) {
                    tail = arr[a - 1];
                    a--;
                }

            }
            for (int i = res.length - 1; i >= 0; i--) {
                System.out.println(res[i]);
            }
        }
    }
}