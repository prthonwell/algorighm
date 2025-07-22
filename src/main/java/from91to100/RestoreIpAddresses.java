package from91to100;

import java.util.ArrayList;
import java.util.List;

class RestoreIpAddresses {
    // https://leetcode.cn/problems/restore-ip-addresses/ 83
    int[] s = new int[4];
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        if (n < 4) return new ArrayList<>();
        char[] chars = s.toCharArray();
        dfs(chars, 0, 0,n - 4);
        return res;
    }

    private void dfs(char[] chars, int cur, int startPos, int rest) {
        if (cur == 4) {
            if (startPos != chars.length) return;
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 3; i++) {
                sb.append(s[i]);
                sb.append('.');
            }
            sb.append(s[3]);
            res.add(sb.toString());
            return;
        }
        int val = 0;
        for (int i = startPos; i < startPos + 3 && i <= startPos + rest; i++) {
            int num = chars[i] - '0';
            val = val * 10 + num;
            if (val == 0) {
                s[cur] = val;
                dfs(chars, cur + 1, i + 1, rest);
                break;
            } else if (val <= 255) {
                s[cur] = val;
                dfs(chars, cur + 1, i + 1, rest + startPos - i);
            }
        }
    }

    public static void main(String[] args) {
        RestoreIpAddresses r = new RestoreIpAddresses();
        System.out.println(r.restoreIpAddresses("101023"));
    }
}