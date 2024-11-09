package LEC22;
import java.util.*;

public class Path_With_Maximum_Gold {
    public void collectGold(int[][] arr, int row, int col, List<Integer> bag, boolean[][] vis) {
        if (row < 0 || col < 0 || row >= arr.length || col >= arr[0].length
                || vis[row][col] == true || arr[row][col] == 0) return;

        vis[row][col] = true;
        bag.add(arr[row][col]);
        collectGold(arr, row - 1, col, bag, vis);
        collectGold(arr, row + 1, col, bag, vis);
        collectGold(arr, row, col - 1, bag, vis);
        collectGold(arr, row, col + 1, bag, vis);
        //vis[row][col] = false;
    }

    public int getMaximumGold(int[][] grid) {
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0 && visited[i][j] == false) {
                    List<Integer> bag = new ArrayList<>();
                    collectGold(grid, i, j, bag, visited);

                    int sum = 0;
                    for (int val : bag) {
                        sum += val;
                    }
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
        }
        return max;
    }
}