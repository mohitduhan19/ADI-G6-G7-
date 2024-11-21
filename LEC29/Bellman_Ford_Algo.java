package LEC29;

public class Bellman_Ford_Algo {
    static int[] bellmanFord(int V, int[][] edges, int src) {
        // Write your code here
        int[] dist= new int[V];
        for(int i = 0;i < V;i++)dist[i] = (int)(1e8);
        dist[src] = 0;

        for(int i = 0;i < V;i++){
            for(int[] lis : edges){
                int u = lis[0];
                int v = lis[1];
                int wt = lis[2];
                if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        for(int[] lis : edges){
            int u = lis[0];
            int v = lis[1];
            int wt = lis[2];
            if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }
}
