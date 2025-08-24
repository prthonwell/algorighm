package leetCode.from161to200;

public class NumIslands200 {

    static int[][] offset = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    res++;
                    dfs(visited, grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(boolean[][] visited, char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length
                || visited[x][y] || grid[x][y] == '0') return;
        visited[x][y] = true;
        for (int[] offset : offset) {
            int newX = x + offset[0];
            int newY = y + offset[1];
            dfs(visited, grid, newX, newY);
        }
    }
}
