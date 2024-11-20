package LEC28;
import java.util.*;

public class Number_Of_Islands {
    class pair {
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void bfs(int r, int c, char[][] grid, int[][] vis, int n, int m) {
        vis[r][c] = 1;
        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(r, c));
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            pair p = q.remove();
            int row = p.x;
            int col = p.y;
            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == 0 && grid[nr][nc] == '1') {
                    vis[nr][nc] = 1;
                    q.add(new pair(nr, nc));
                }
            }

        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int islands = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    islands++;
                    bfs(i, j, grid, vis, n, m);
                }
            }
        }
        return islands;
    }
}
