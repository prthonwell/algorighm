package huweiA;

import java.util.*;

public class Ode0045 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] boarder = new int[4]; // 0:top, 1:bottom, 2:left, 3:right
        int x = sc.nextInt();
        int y = sc.nextInt();
        boarder[2] = x;
        boarder[3] = x + 50;
        boarder[0] = y;
        boarder[1] = y + 25;
        int time = sc.nextInt(), cur = 0;
        sc.close();
        int[] speed = new int[2]; // 0:x 1:y
        speed[0] = 1;
        speed[1] = 1;
        while (cur < time) {
            if (boarder[0] == 0 || boarder[1] == 600) speed[1] = -speed[1];
            if (boarder[2] == 0 || boarder[3] == 800) speed[0] = -speed[0];
            boarder[0] += speed[1];
            boarder[1] += speed[1];
            boarder[2] += speed[0];
            boarder[3] += speed[0];
            cur++;
        }
        System.out.println(boarder[2] + " " + boarder[0]);
    }
}
