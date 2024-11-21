package LEC29;

public class Floyd_Warshall_Algo {
    public void shortestDistance(int[][] mat) {
        int n = mat.length;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(mat[i][j] == -1){
                    mat[i][j] = (int)(1e8);
                }
                if(i == j)mat[i][j] = 0;
            }
        }

        for(int k = 0;k < n;k++){
            for(int i = 0; i < n;i++){
                for(int j = 0;j < n;j++){
                    mat[i][j] = Math.min(mat[i][j] , mat[i][k] + mat[k][j]);
                }
            }
        }

        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(mat[i][j] == (int)(1e8)){
                    mat[i][j] = -1;
                }
            }
        }


    }
}
