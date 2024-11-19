package LEC27;
import java.util.*;

public class Dfs_Traversal {
    public void dfs(int node ,boolean[] vis , ArrayList<ArrayList<Integer>> adj , ArrayList<Integer> lis){
        vis[node] = true;
        lis.add(node);

        for(Integer i : adj.get(node)){
            if(vis[i] == false){
                dfs(i , vis , adj , lis);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[adj.size()+1];
        vis[0] = true;
        ArrayList<Integer> lis = new ArrayList<>();
        dfs(0 , vis, adj , lis);
        return lis;
    }
}
