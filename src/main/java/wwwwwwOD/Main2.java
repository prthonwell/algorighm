package wwwwwwOD;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main2 {

    static class IPLevel {
        String city;
        IPLevel[] next;
        IPLevel(String city) {
            this.city = city;
            next  = new IPLevel[256];
        }
        IPLevel() {
            next  = new IPLevel[256];
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] Cities = in.nextLine().split(";");
        String[] IPS = in.nextLine().split(",");
        in.close();
        IPLevel src = new IPLevel();
        String[][][][] ipMap = new String[255][255][255][255];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < Cities.length; i++) {
            String[] ss = Cities[i].split("=");
            String[] ips = ss[1].split(",");
            String[] ip1 = ips[0].split("\\.");
            String[] ip2 = ips[1].split("\\.");
            int[] ip1Num = new int[4];
            int[] ip2Num = new int[4];
            int[] ip = new int[9];
            int len = 0;
            for (int j = 0; j < 4; j++) {
                ip1Num[j] = Integer.parseInt(ip1[j]);
                ip2Num[j] = Integer.parseInt(ip2[j]);
                len = len * 255 + ip2Num[j] - ip1Num[j];
            }
            while (ip1Num[0] < ip2Num[0]
                    || ip1Num[1] < ip2Num[1]
                    || ip1Num[2] < ip2Num[2]
                    || ip1Num[3] < ip2Num[3]) {
                if (ipMap[ip1Num[0]][ip1Num[1]][ip1Num[2]][ip1Num[3]] == null) {
                    ipMap[ip1Num[0]][ip1Num[1]][ip1Num[2]][ip1Num[3]] = ss[0];
                } else {
                    if (map.get(ss[0]) < map.get(ipMap[ip1Num[0]][ip1Num[1]][ip1Num[2]][ip1Num[3]])) {
                        ipMap[ip1Num[0]][ip1Num[1]][ip1Num[2]][ip1Num[3]] = ss[0];
                    }
                }
                ip1Num[3]++;
                if (ip1Num[3] == 256) {
                    ip1Num[3] = 0;
                    ip1Num[2]++;
                    if (ip1Num[2] == 256) {
                        ip1Num[2] = 0;
                        ip1Num[1]++;
                        if (ip1Num[1] == 256) {
                            ip1Num[1] = 0;
                            ip1Num[0]++;
                        }
                    }
                }
            }
            map.put(ss[0], len);
            ip[8] = len;
        }
        StringJoiner sj = new StringJoiner(",");
        for (String ips : IPS) {
            String[] ip = ips.split("\\.");
            int[] cur = new int[4];
            for (int i = 0; i < 4; i++) {
                cur[i] = Integer.parseInt(ip[i]);
            }
            if (ipMap[cur[0]][cur[1]][cur[2]][cur[3]] == null) {
                sj.add("");
            } else {
                sj.add(ipMap[cur[0]][cur[1]][cur[2]][cur[3]]);
            }
        }
        System.out.println(sj.toString());
    }
}