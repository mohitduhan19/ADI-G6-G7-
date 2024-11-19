package LEC27;
import java.util.*;

public class Bfs_Traversal {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> ls = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        vis[0] = true;

        while(!q.isEmpty()){
            Integer node = q.poll();
            ls.add(node);

            for(Integer i : adj.get(node)){
                if(vis[i] == false){
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
        return ls;
    }
}
