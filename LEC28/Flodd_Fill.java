package LEC28;

public class Flodd_Fill {
    public void dfs(int r , int c , int[][]ans , int[][] image ,
                    int newColor ,int[]delr , int[]delc,int initColor){
        ans[r][c] = newColor;
        int n = image.length , m = image[0].length;

        for(int i = 0;i < 4;i++){
            int nrow= r + delr[i];
            int ncol = c + delc[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                    && image[nrow][ncol] == initColor && ans[nrow][ncol] !=newColor){
                dfs(nrow , ncol , ans , image , newColor , delr , delc, initColor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here
        int intitalColor = image[sr][sc];
        int[][] ans = image;

        int[] delr = {-1 , 0 , 1 , 0};
        int[] delc = {0 , 1 ,0 , -1};

        dfs(sr , sc , ans , image , newColor , delr , delc , intitalColor);
        return ans;
    }
}
