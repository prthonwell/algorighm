package huaweiB;

import java.util.*;

public class ode0163 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<int[]> occupied = new ArrayList<>();
        List<String> res = new ArrayList<>();
        out: for ( int i = 0; i < n; i++ ) {
            String[] ss = sc.nextLine().split("=");
            int num = Integer.parseInt(ss[1]);
            if ( ss[0].equals("REQUEST")) {
                if (num == 0) {
                    res.add("error");
                    return;
                }
                occupied.sort((a,b)-> a[0] - b[0]);
                int start = 0;
                int index = 0;
                while ( index < occupied.size() ) {
                    int size = occupied.get(index)[0] - start;
                    if ( size >= num ) {
                        occupied.add(index, new int[] { start, start + num });
                        res.add( start + "");
                        continue out;
                    }
                    start = occupied.get(index)[1];
                    index++;
                }
                int size = 100 - start;
                if ( size >= num ) {
                    occupied.add(index, new int[] { start, start + num });
                    res.add( start + "");
                    continue out;
                }
                res.add("error");
            } else {
                int index = 0;
                while ( index < occupied.size() && occupied.get(index)[0] < num ) {
                    index++;
                }
                if ( occupied.get(index)[0] == num ) {
                    occupied.remove(index);
                } else {
                    res.add("error");
                }
            }
        }
        for (String s : res) {
            System.out.println(s);
        }
    }
}
