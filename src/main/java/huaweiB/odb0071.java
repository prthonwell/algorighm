package huaweiB;

import java.util.*;

public class odb0071 {
    static HashMap<String, int[]> move = new HashMap<>();
    static {
        move.put( "U", new int[]{ -1, 0} );
        move.put( "D", new int[]{ 1, 0} );
        move.put( "R", new int[]{ 0, 1} );
        move.put( "L", new int[]{ 0, -1} );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] moves = sc.nextLine().split(" ");
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        String[][] matrix = new String[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = sc.nextLine().split(" ");
        }
        sc.close();
        Deque<int[]> body = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j].equals("H")) {
                    body.offer(new int[]{i, j});
                }
            }
        }
        int[] lastMove = new int[2];
        for (int i = 0; i < moves.length; i++) {
            String cur = moves[i];
            int[] head = new int[2];
            head[0] = body.peekFirst()[0];
            head[1] = body.peekFirst()[1];
            if (cur.equals("G")) {
                head[0] += lastMove[0];
                head[1] += lastMove[1];
            } else {
                lastMove[0] = move.get(cur)[0];
                lastMove[1] = move.get(cur)[1];
                continue;
            }
            int[] tail = new int[2];
            tail[0] = body.peekLast()[0];
            tail[1] = body.peekLast()[1];
            if (head[0] < 0 || head[1] < 0 || head[0] >= n || head[1] >= m) {
                System.out.println(body.size());
                return;
            }
            if (matrix[head[0]][head[1]].equals("H") && !(head[0] == tail[0] && head[1] == tail[1])) {
                System.out.println(body.size());
                return;
            }

            if (matrix[head[0]][head[1]].equals("F")) {
                body.addFirst(head);
                matrix[head[0]][head[1]] = "H";
            } else if (matrix[head[0]][head[1]].equals("E") || (head[0] == tail[0] && head[1] == tail[1])) {
                int[] end = body.pollLast();
                body.addFirst(head);
                matrix[head[0]][head[1]] = "H";
                matrix[end[0]][end[1]] = "E";
            }
        }
        System.out.println(body.size());
    }
}
