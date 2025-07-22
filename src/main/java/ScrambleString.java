import java.util.concurrent.ConcurrentHashMap;

public class ScrambleString {
    // 给定两个字符串判断是不是护卫玄变
    private static Boolean filter (String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[][][] dp = new int[n][n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (str1[i] == str2[j]) dp[i][j][1] = 1;
            }
        }
        for (int level = 2; level <= n; level++) {
            for (int i = 0; i + level <= n; i++) {
                for (int j = 0; j + level <= n; j++) {
                    int flag = 0;
                    for (int k = 1; k < level; k++) {
                        if (dp[i + k][j + k][level - k] == 1 && dp[i][j][k] == 1) flag = 1;
                        if (dp[i][j + level - k][k] == 1 && dp[i+k][j][level - k] == 1) flag = 1;
                    }
                    dp[i][j][level] = flag;
                }
            }
        }
        return dp[0][0][n] == 1;
    }


    public static void main(String[] args) {
        ThreadLocal<Integer> LocalInt = new ThreadLocal<>();
        ConcurrentHashMap<TestObject,String> map = new ConcurrentHashMap<>();
        TestObject o1 = new TestObject(1);
        TestObject o2 = new TestObject(1);
        map.put(o1, "1");
        System.out.println(map.get(o2));
        String a = "abc";
        String b = "cba";
        System.out.println(filter(a, b));
    }

}
