package huweiB;

import java.util.*;
import java.util.regex.Pattern;

public class ode0029 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        out : for ( int i = 0; i < n; i++ ) {
            String[] line = sc.nextLine().split(" ");
            int absent = 0;
            int lateOrLeaveEarly = 0;
            boolean PreLOL = false;
            for ( int j = 0; j < line.length; j++ ) {
                if ( line[j].equals("absent") ) {
                    absent++;
                    if (absent > 1) {
                        System.out.print("false ");
                        continue out;
                    }
                    PreLOL = false;
                }
                else if ( line[j].equals("late") || line[j].equals("leaveearly") ) {
                    if ( PreLOL ) {
                        System.out.print("false ");
                        continue out;
                    }
                    lateOrLeaveEarly++;
                    if (j >= 7 && (line[j - 7].equals("late") || line[j - 7].equals("leaveearly"))) {
                        lateOrLeaveEarly--;
                    }
                    if (lateOrLeaveEarly > 3) {
                        System.out.print("false ");
                        continue out;
                    }
                    PreLOL = true;
                } else {
                    PreLOL = false;
                }
            }
            System.out.print("true ");
        }
        sc.close();
    }
}
