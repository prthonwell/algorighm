package huaweiB;

import java.util.*;

public class ode0164 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> putIn = Arrays
                .stream(sc.nextLine().split(","))
                .map(Integer::parseInt)
                .toList();
        List<Integer> takeOut = Arrays
                .stream(sc.nextLine().split(","))
                .map(Integer::parseInt)
                .toList();
        List<Integer> Q = new ArrayList<>();
        int r = -1, putI = 0;
        List<String> res = new ArrayList<>();
        for (Integer out : takeOut) {
            while (putI < putIn.size()
                    && (Q.isEmpty() || (!Objects.equals(Q.get(0), out) && !Objects.equals(Q.get(r), out)))) {
                Q.add(putIn.get(putI++));
                r++;
            }
            if (Objects.equals(Q.get(0), out)) {
                Q.remove(0);
                res.add("L");
                r--;
                continue;
            } else if (Objects.equals(Q.get(r), out)) {
                Q.remove(r);
                res.add("R");
                r--;
                continue;
            }
            if (putI == putIn.size()) {
                System.out.println("NO");
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : res) {
            sb.append(s);
        }
        System.out.println(sb.toString());
    }
}
