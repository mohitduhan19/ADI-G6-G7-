package LEC27;
import java.util.*;

class pair {
    int src;
    int parent;
    pair(int src , int parent) {
        this.src = src;
        this.parent = parent;
    }
}

public class Undirected_Graph_Cycle {
    public boolean checkcycle(int src, int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[src] = true;
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(src, -1));

        while (!q.isEmpty()) {
            pair current = q.poll();
            int node = current.src;
            int par = current.parent;

            for (int adjNode : adj.get(node)) {
                if (!vis[adjNode]) {
                    vis[adjNode] = true;
                    q.add(new pair(adjNode, node));
                } else if (par != adjNode) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[adj.size()];
        Arrays.fill(vis, false);

        for (int i = 0; i < adj.size(); i++) {
            if (!vis[i]) {
                if (checkcycle(i, adj.size(), adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

}
