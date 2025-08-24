package huaweiB;

import java.util.*;

public class ode0130 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt(), end = sc.nextInt();
        List<List<Integer>> res = new ArrayList<>();
        for ( int i = start; i <= end; i++ ) {
            for ( int j = i + 1; j <= end; j++ ) {
                int goal = i * i + j * j;
                if ( goal < (j + 1) * (j + 1)) break;
                int index = j, plus = 1;
                while (index + plus <= end && (index + plus) * (index + plus) < goal) {
                    while (index + plus <= end && (index + plus) * (index + plus) < goal ) {
                        plus *= 2;
                    }
                    index += plus / 2;
                    plus = 1;
                }
                if (goal == (index + plus) * (index + plus) && isSu(i,j,index + plus)) {
                    res.add(Arrays.asList(i, j, index + plus));
                }
            }
        }
        if (res.isEmpty()) {
            System.out.println("NA");
            return;
        }
        for ( List<Integer> list : res ) {
            String[] r = list.stream().map( String::valueOf ).toArray( String[]::new );
            System.out.println(String.join(" ",r));
        }
        sc.close();
    }

    private static boolean isSu(int i, int j, int k) {
        for (int s = 2; s <= i; s++) {
            if (i % s == 0 && j % s == 0 && k % s == 0) {
                return false;
            }
        }
        return true;
    }
}
