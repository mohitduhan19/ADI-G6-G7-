package LEC29;
import java.util.*;

class triple{
    int f , s , t;
    triple(int f ,int s , int t){
        this.f = f;
        this.s = s;
        this.t = t;
    }
}
public class Shortest_Distance_In_Binary_Maze {

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        if(source[0] == destination[0] && source[1] == destination[1])return 0;
        Queue<triple> q= new ArrayDeque<>();
        int n = grid.length , m = grid[0].length;
        int[][] dist= new int[n][m];

        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                dist[i][j] = (int)(1e8);
            }
        }
        dist[source[0]][source[1]] = 0;
        q.add(new triple(0 , source[0] , source[1]));
        int[] dr = {-1 , 0 , 1 , 0};
        int[] dc = {0 , 1 , 0 , -1};

        while(q.size() > 0){
            triple tp = q.peek();
            q.remove();
            int dis = tp.f;
            int r = tp.s;
            int c = tp.t;

            for(int i = 0;i < 4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 &&nc  < m &&
                        grid[nr][nc] == 1 && dis + 1 < dist[nr][nc]){
                    dist[nr][nc] = 1 + dis;
                    if(nr == destination[0] && nc == destination[1])return dis + 1;
                    q.add(new triple(1+dis , nr , nc));
                }
            }
        }
        return -1;
    }
}
