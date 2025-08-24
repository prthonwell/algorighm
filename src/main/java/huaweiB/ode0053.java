package huaweiB;

import java.util.*;

public class ode0053 {

    static class stu {
        String name;
        int[] scores;

        stu( String name, int len ) {
            this.name = name;
            scores = new int[ len ];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String[] line = sc.nextLine().split(" ");
        HashMap< String, Integer > map = new HashMap<>();
        int index = 0;
        for ( int i = 0; i < m; i++ ) {
            map.put( line[i], index++ );
        }
        List<stu> stus = new ArrayList<>();
        for ( int i = 0; i < n; i++ ) {
            String[] s = sc.nextLine().split(" ");
            stu stu = new stu( s[ 0 ], m);
            for ( int j = 0; j < m; j++ ) {
                stu.scores[j] = Integer.parseInt(s[j + 1]);
            }
            stus.add( stu );
        }
        String s = sc.nextLine();
        if (map.containsKey( s )) {
            int finalIndex = map.get( s );
            stus.sort(new Comparator<stu>() {
                @Override
                public int compare(stu o1, stu o2) {
                    return o2.scores[finalIndex] - o1.scores[finalIndex];
                }
            });
        } else {
            stus.sort(new Comparator<stu>() {
                @Override
                public int compare(stu o1, stu o2) {
                    int sum1 = 0;
                    int sum2 = 0;
                    for (int i = 0; i < o1.scores.length; i++ ) {
                        sum1 += o1.scores[i];
                        sum2 += o2.scores[i];
                    }
                    return sum2 - sum1;
                }
            });
        }
        StringJoiner sj = new StringJoiner( " " );
        for ( stu stu : stus ) {
            sj.add( stu.name );
        }
        System.out.println( sj.toString() );
    }
}
